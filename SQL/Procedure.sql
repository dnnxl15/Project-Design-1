/*-- --------------------------------------------------------------------------------
--                                      INSERTS
-- --------------------------------------------------------------------------------

-- Procedure to insert Client
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table client, all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertClient`(IN `pName` VARCHAR(100), IN `pLastname` VARCHAR(100), IN `pIdentification` VARCHAR(100),
	IN `pUsername` VARCHAR(100), IN `pEmail` VARCHAR(100), IN `pPassword` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Client'
BEGIN 
	INSERT INTO Person(personID, name, lastname, identification)
	VALUES(NULL, pName, pLastname, pIdentification);
	INSERT INTO Client(clientID, username, email, password, personID)
	VALUES(NULL, pUsername, pEmail, pPassword, (SELECT personID FROM person ORDER BY personID DESC LIMIT 1));
END$$
DELIMITER ;

-- Procedure to insert Manager
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Manager, all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertManager`(IN `pName` VARCHAR(100), IN `pLastname` VARCHAR(100), IN `pIdentification` VARCHAR(100),
	IN `pUsername` VARCHAR(100), IN `pPassword` VARCHAR(100), IN `pSalary` FLOAT(11), IN `pJobTitle` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Manager'
BEGIN 
	INSERT INTO Person(personID, name, lastname, identification)
	VALUES(NULL, pName, pLastname, pIdentification);
	INSERT INTO Manager(managerID, username, password, salary, jobTitleID, personID)
	VALUES(NULL, pUsername, pPassword, pSalary, getJobTitleID(pJobTitle), (SELECT personID FROM person ORDER BY personID DESC LIMIT 1));
END$$
DELIMITER ;

-- Procedure to insert Employee
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Employee, all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployee`(IN `pName` VARCHAR(100), IN `pLastname` VARCHAR(100), IN `pIdentification` VARCHAR(100),
	IN `pEmail` VARCHAR(100), IN `pJobTitle` VARCHAR(100), IN `pSalary` FLOAT(11))
    NO SQL
    COMMENT 'Procedure that insert into the table Employee'
BEGIN 
	INSERT INTO Person(personID, name, lastname, identification)
	VALUES(NULL, pName, pLastname, pIdentification);
	INSERT INTO Employee(employeeID, email, salary, jobTitleID, personID)
	VALUES(NULL, pEmail, pSalary, getJobTitleID(pJobTitle), (SELECT personID FROM person ORDER BY personID DESC LIMIT 1));
END$$
DELIMITER ;

-- Procedure to insert Job title
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Job title, all the data and in the table salary if the range does not exist.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertJobTitle`(IN `pName` VARCHAR(100), IN `pMinSalary` FLOAT(11), IN `pMaxSalary` FLOAT(11))
    NO SQL
    COMMENT 'Procedure that insert into the table Job title'
BEGIN 
	INSERT IGNORE INTO Salary(salaryID, minSalary, maxSalary)
	VALUES(NULL, pMinSalary, pMaxSalary);
	INSERT INTO JobTitle(jobTitleID, name, salaryID)
	VALUES(NULL, pName, getSalaryRangeID(pMinSalary, pMaxSalary));
END$$
DELIMITER ;

-- Procedure to insert Vehicle
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Vehicle all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertVehicle`(IN `pRegNum` VARCHAR(100), IN `pModel` VARCHAR(100), IN `pYear` INT(11))
    NO SQL
    COMMENT 'Procedure that insert into the table Vehicle'
BEGIN 
	INSERT IGNORE INTO Vehicle(vehicleID, registrationNumber, model, year)
	VALUES(NULL, pRegNum, pModel, pYear);
END$$
DELIMITER ;

-- Procedure to insert Restaurant
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Restaurant all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertRestaurant`(IN `pAddress` VARCHAR(100), IN `pLegalNumber` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Restaurant'
BEGIN 
	INSERT IGNORE INTO Restaurant(restID, address, legalNumber)
	VALUES(NULL, pAddress, pLegalNumber);
END$$
DELIMITER ;


-- Procedure to insert Vehicle by employee
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table VehicleByEmployee all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertVehicleByEmployee`(IN `pRegNum` VARCHAR(100), IN `pIdentificator` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table VehicleByEmployee'
BEGIN 
	INSERT IGNORE INTO VehicleByEmployee(vehicleByEmployeeID, personID, vehicleID)
	VALUES(NULL, getPersonID(pIdentificator), getVehicleID(pRegNum));
END$$
DELIMITER ;

-- Procedure to insert employee by restaurant
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table EmployeeByRestaurant all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployeeByRest`(IN `pLegalNumber` VARCHAR(100), IN `pIdentificator` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table EmployeeByRestaurant'
BEGIN 
	INSERT IGNORE INTO EmployeeByRest(employeeByRestID, personID, restID)
	VALUES(NULL, getPersonID(pIdentificator), getRestID(pLegalNumber));
END$$
DELIMITER ;

-- Procedure to insert a product
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Product all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProduct`(IN `pName` VARCHAR(100), IN `pPrice` FLOAT(11), IN `pDescription` VARCHAR(100), IN `pIdentificator` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Product'
BEGIN 
	INSERT IGNORE INTO Product(productID, name, price, description, status, personID)
	VALUES(NULL, pName, pPrice, pDescription, 1, getPersonID(pIdentificator));
END$$
DELIMITER ;

-- Procedure to insert a Combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Combo all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCombo`(IN `pName` VARCHAR(100), IN `pPrice` FLOAT(11), IN `pDescription` VARCHAR(100), IN `pIdentificator` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Combo'
BEGIN 
	INSERT IGNORE INTO Combo(comboID, name, price, description, status, personID)
	VALUES(NULL, pName, pPrice, pDescription, 1, getPersonID(pIdentificator));
END$$
DELIMITER ;

-- Procedure to insert a product by combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ProductByCombo all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductByCombo`(IN `pProduct` VARCHAR(100), IN `pCombo` VARCHAR(100), IN `pQuantity` INT(11))
    NO SQL
    COMMENT 'Procedure that insert into the table ProductByCombo'
BEGIN 
	INSERT IGNORE INTO ProductByCombo(productByComboID, quantity, productID, comboID)
	VALUES(NULL, pQuantity, getProductID(pProduct), getComboID(pCombo));
END$$
DELIMITER ;

-- Procedure to insert a product purchase
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ProductPurchase all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductPurchase`(IN `pProduct` VARCHAR(100), IN `pQuantity` INT(11), IN `pTime` DATETIME,
	IN `pUsername` VARCHAR(100), IN `pDeliveryType` BOOLEAN, IN `pPayMethod` BOOLEAN)
    NO SQL
    COMMENT 'Procedure that insert into the table ProductPurchase'
BEGIN 
	INSERT INTO ProductPurchase(productPurchaseID, quantity, purchaseTime, productID)
	VALUES(NULL, pQuantity, pTime, getProductID(pProduct));
	CALL insertProductPurchaseByClient(pUsername);
	CALL insertProductPurchaseInfo(pDeliveryType, pPayMethod);
END$$
DELIMITER ;

-- Procedure to insert a product purchase by client
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ProductPurchaseByClient all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductPurchaseByClient`(IN `pUsername` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table ProductPurchaseByClient'
BEGIN 
	INSERT INTO ProductPurchaseByClient(productPurchaseByClientID, personID, productPurchaseID)
	VALUES(NULL, getClientID(pUsername), (SELECT productPurchaseID FROM ProductPurchase ORDER BY productPurchaseID DESC LIMIT 1));
END$$
DELIMITER ;

-- Procedure to insert a product purchase info
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ProductPurchaseInfo all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductPurchaseInfo`(IN `pDeliveryType` BOOLEAN, IN `pPayMethod` BOOLEAN)
    NO SQL
    COMMENT 'Procedure that insert into the table ProductPurchaseInfo'
BEGIN 
	INSERT INTO ProductPurchaseInfo(productPurchaseInfoID, productPurchaseID, deliveryType, payMethod, startOfPreparation, endOfPreparation, startOfDelivery, endOfDelivery)
	VALUES(NULL, (SELECT productPurchaseID FROM ProductPurchase ORDER BY productPurchaseID DESC LIMIT 1), pDeliveryType, pPayMethod, NULL, NULL, NULL, NULL);
END$$
DELIMITER ;

-- Procedure to insert a combo purchase
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ComboPurchase all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertComboPurchase`(IN `pCombo` VARCHAR(100), IN `pQuantity` INT(11), IN `pTime` DATETIME,
	IN `pUsername` VARCHAR(100), IN `pDeliveryType` BOOLEAN, IN `pPayMethod` BOOLEAN)
    NO SQL
    COMMENT 'Procedure that insert into the table ComboPurchase'
BEGIN 
	INSERT INTO ComboPurchase(comboPurchaseID, quantity, purchaseTime, comboID)
	VALUES(NULL, pQuantity, pTime, getComboID(pCombo));
	CALL insertComboPurchaseByClient(pUsername);
	CALL insertComboPurchaseInfo(pDeliveryType, pPayMethod);
END$$
DELIMITER ;

-- Procedure to insert a product Combo by client
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ComboPurchaseByClient all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertComboPurchaseByClient`(IN `pUsername` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table ComboPurchaseByClient'
BEGIN 
	INSERT INTO ComboPurchaseByClient(ComboPurchaseByClientID, personID, ComboPurchaseID)
	VALUES(NULL, getClientID(pUsername), (SELECT comboPurchaseID FROM ComboPurchase ORDER BY ComboPurchaseID DESC LIMIT 1));
END$$
DELIMITER ;

-- Procedure to insert a product Combo info
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table ComboPurchaseInfo all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertComboPurchaseInfo`(IN `pDeliveryType` BOOLEAN, IN `pPayMethod` BOOLEAN)
    NO SQL
    COMMENT 'Procedure that insert into the table ComboPurchaseInfo'
BEGIN 
	INSERT INTO ComboPurchaseInfo(comboPurchaseInfoID, comboPurchaseID, deliveryType, payMethod, startOfPreparation, endOfPreparation, startOfDelivery, endOfDelivery)
	VALUES(NULL, (SELECT ComboPurchaseID FROM ComboPurchase ORDER BY ComboPurchaseID DESC LIMIT 1), pDeliveryType, pPayMethod, NULL, NULL, NULL, NULL);
END$$
DELIMITER ;

-- Procedure to insert a employee do product
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table EmployeeDoProduct all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployeeDoProduct`(IN `pTime` DATETIME, IN `pEmail` VARCHAR(100), IN `pPercentage` FLOAT(11))
    NO SQL
    COMMENT 'Procedure that insert into the table EmployeeDoProduct'
BEGIN 
	INSERT INTO EmployeeDoProduct(employeeDoProductID, personID, productPurchaseID, percentage)
	SELECT NULL, getPersonID(pEmail), pp.productPurchaseID, pPercentage FROM ProductPurchase pp WHERE pp.purchaseTime = pTime;
END$$
DELIMITER ;

-- Procedure to insert a employee do Combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table EmployeeDoCombo all the data.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployeeDoCombo`(IN `pTime` DATETIME, IN `pEmail` VARCHAR(100), IN `pPercentage` FLOAT(11))
    NO SQL
    COMMENT 'Procedure that insert into the table EmployeeDoCombo'
BEGIN 
	INSERT INTO EmployeeDoCombo(employeeDoComboID, personID, comboPurchaseID, percentage)
	SELECT NULL, getPersonID(pEmail), cp.comboPurchaseID, pPercentage FROM ComboPurchase cp WHERE cp.purchaseTime = pTime;
END$$
DELIMITER ;

-- --------------------------------------------------------------------------------
--                                  UPDATE
-- --------------------------------------------------------------------------------
-- Procedure to updateStartOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure call the procedures to update the start of preparation.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStartOfPreparation`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	CALL updateProductStartOfPreparation(pTime);
	CALL updateComboStartOfPreparation(pTime);
END$$
DELIMITER ;

-- Procedure to updateEndOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure call the procedures to update the End of preparation.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEndOfPreparation`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the EndOfPreparation'
BEGIN 
	CALL updateProductEndOfPreparation(pTime);
	CALL updateComboEndOfPreparation(pTime);
END$$
DELIMITER ;

-- Procedure to updateStartOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure call the procedures to update the start of Delivery.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStartOfDelivery`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the startOfDelivery'
BEGIN 
	CALL updateProductStartOfDelivery(pTime);
	CALL updateComboStartOfDelivery(pTime);
END$$
DELIMITER ;

-- Procedure to updateEndOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure call the procedures to update the end of Delivery.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEndOfDelivery`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the endOfDelivery'
BEGIN 
	CALL updateProductEndOfDelivery(pTime);
	CALL updateComboEndOfDelivery(pTime);
END$$
DELIMITER ;

-- Procedure to updateProductStartOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ProductPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProductStartOfPreparation`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	UPDATE ProductPurchaseInfo ppi
	INNER JOIN ProductPurchase pp  
    SET ppi.startOfPreparation = NOW() 
    WHERE ppi.productPurchaseID = pp.productPurchaseID AND pp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateProductEndOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ProductPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProductEndOfPreparation`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the endOfPreparation'
BEGIN 
	UPDATE ProductPurchaseInfo ppi
	INNER JOIN ProductPurchase pp  
    SET ppi.endOfPreparation = NOW() 
    WHERE ppi.productPurchaseID = pp.productPurchaseID AND pp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateProductStartOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ProductPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProductStartOfDelivery`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the startOfDelivery'
BEGIN 
	UPDATE ProductPurchaseInfo ppi
	INNER JOIN ProductPurchase pp  
    SET ppi.startOfDelivery = NOW() 
    WHERE ppi.productPurchaseID = pp.productPurchaseID AND pp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateProductEndOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ProductPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProductEndOfDelivery`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the endOfDelivery'
BEGIN 
	UPDATE ProductPurchaseInfo ppi
	INNER JOIN ProductPurchase pp  
    SET ppi.endOfDelivery = NOW() 
    WHERE ppi.productPurchaseID = pp.productPurchaseID AND pp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateComboStartOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ComboPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateComboStartOfPreparation`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	UPDATE ComboPurchaseInfo cpi
	INNER JOIN ComboPurchase cp  
    SET cpi.startOfPreparation = NOW() 
    WHERE cpi.comboPurchaseID = cp.comboPurchaseID AND cp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateComboEndOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ComboPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateComboEndOfPreparation`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the endOfPreparation'
BEGIN 
	UPDATE ComboPurchaseInfo cpi
	INNER JOIN ComboPurchase cp  
    SET cpi.endOfPreparation = NOW() 
    WHERE cpi.comboPurchaseID = cp.comboPurchaseID AND cp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateComboStartOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ComboPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateComboStartOfDelivery`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the startOfDelivery'
BEGIN 
	UPDATE ComboPurchaseInfo cpi
	INNER JOIN ComboPurchase cp  
    SET cpi.startOfDelivery = NOW() 
    WHERE cpi.productPurchaseID = cp.ComboPurchaseID AND cp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to updateComboEndOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table ComboPurchaseInfo.
-- Last modification: 14/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateComboEndOfDelivery`(IN `pTime` DATETIME)
    NO SQL
    COMMENT 'Procedure that update the endOfDelivery'
BEGIN 
	UPDATE ComboPurchaseInfo cpi
	INNER JOIN ComboPurchase cp  
    SET cpi.endOfDelivery = NOW() 
    WHERE cpi.ComboPurchaseID = cp.ComboPurchaseID AND cp.purchaseTime = pTime;
END$$
DELIMITER ; 

-- Procedure to General manager password and username
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table Manager.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateGeneralManager`(IN `pManagerID` INT(11), IN `pNewUsername` VARCHAR(100), IN `pNewPassword` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that update the General Manager'
BEGIN 
	UPDATE Manager m
	SET m.username = pNewUsername,
	m.password = pNewPassword 
    WHERE m.managerID = pManagerID;
END$$
DELIMITER ; 

-- --------------------------------------------------------------------------------
-- 								GET INFORMATION
-- --------------------------------------------------------------------------------

-- Procedure to get Manager information
-- Author: Esteban Coto Alfaro
-- Description: This procedure get manager information.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getManagerInfo`(IN `pUsername` VARCHAR(100), IN `pPassword` VARCHAR(100))
    NO SQL
BEGIN
SELECT * 
FROM Manager
WHERE Manager.username = pUsername AND Manager.password = pPassword;
END$$
DELIMITER ; 

-- Procedure to get Jobs  Titles
-- Author: Esteban Coto Alfaro
-- Description: This procedure get Job titles.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getJobTitle`()
    NO SQL
BEGIN
SELECT JobTitle.name, Salary.minSalary, Salary.maxSalary 
FROM JobTitle, Salary
WHERE JobTitle.salaryID = Salary.salaryID;
END$$
DELIMITER ; 

-- Procedure to get Restaurant
-- Author: Esteban Coto Alfaro
-- Description: This procedure get Restaurants.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRestaurant`()
    NO SQL
BEGIN
SELECT restaurant.*
FROM Restaurant;
END$$
DELIMITER ;

-- Procedure to get Products
-- Author: Esteban Coto Alfaro
-- Description: This procedure get products.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAvailableProduct`()
    NO SQL
BEGIN
SELECT Product.*
FROM product
WHERE product.status = 1;
END$$
DELIMITER ;

-- Procedure to get Combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure get Combo.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAvailableCombo`()
    NO SQL
BEGIN
SELECT combo.*
FROM Combo
WHERE combo.status = 1;
END$$
DELIMITER ;

-- Procedure to get All products
-- Author: Esteban Coto Alfaro
-- Description: This procedure get all products.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllProduct`()
    NO SQL
BEGIN
SELECT product.name
FROM Product;
END$$
DELIMITER ;

-- Procedure to get All combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure get combo.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCombo`()
    NO SQL
BEGIN
SELECT combo.name
FROM Combo;
END$$
DELIMITER ;

-- Procedure to get unavailable products
-- Author: Esteban Coto Alfaro
-- Description: This procedure get unavailable products.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnavailableProduct`()
    NO SQL
BEGIN
SELECT product.name
FROM Product
WHERE product.status = 0;
END$$
DELIMITER ;

-- Procedure to get unavailable combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure get unavailable combo.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnavailableCombo`()
    NO SQL
BEGIN
SELECT combo.name
FROM combo
WHERE combo.status = 0;
END$$
DELIMITER ;

-- Procedure to Disable products
-- Author: Esteban Coto Alfaro
-- Description: This procedure to disable product.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `disableProduct`(IN `pProduct` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that disable product'
BEGIN 
	UPDATE Product
	SET product.status = 0 
    WHERE product.name = pProduct;
END$$
DELIMITER ;

-- Procedure to Disable Combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure to disable combo.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `disableCombo`(IN `pCombo` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that disable Combo'
BEGIN 
	UPDATE Combo
	SET Combo.status = 0 
    WHERE Combo.name = pCombo;
END$$
DELIMITER ;

-- Procedure to Enable products
-- Author: Esteban Coto Alfaro
-- Description: This procedure to Enable product.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `enableProduct`(IN `pProduct` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that Enable product'
BEGIN 
	UPDATE Product
	SET product.status = 1 
    WHERE product.name = pProduct;
END$$
DELIMITER ;

-- Procedure to Enable Combo
-- Author: Esteban Coto Alfaro
-- Description: This procedure to Enable Combo.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `enableCombo`(IN `pCombo` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that Enable Combo'
BEGIN 
	UPDATE Combo
	SET Combo.status = 1 
    WHERE Combo.name = pCombo;
END$$
DELIMITER ;


-- Procedure to get purchase since DATETIME
-- Author: Esteban Coto Alfaro
-- Description: This procedure to get all the purchase SINCE A DATETIME.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getProductPurchaseSince`(IN `pTime` DATE)
    NO SQL
    COMMENT 'Procedure that get the products purchase since a DATETIME'
BEGIN 
	SELECT DISTINCT getProductName(pp.productID) AS productName, pp.quantity,
	pp.quantity*getProductPrice(getProductName(pp.productID)) AS price, getClientName(ppc.personID) AS Username,
	getRestNum(ppc.restID) AS RestaurantNum, pp.purchaseTime
	FROM ProductPurchase pp, productpurchasebyclient ppc
	WHERE DATE(pp.purchaseTime) = pTime;
END$$
DELIMITER ;

-- Procedure to get purchase since DATETIME
-- Author: Esteban Coto Alfaro
-- Description: This procedure to get all the purchase SINCE A DATETIME.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getComboPurchaseSince`(IN `pTime` DATE)
    NO SQL
    COMMENT 'Procedure that get the Combo purchase since a DATETIME'
BEGIN 
	SELECT DISTINCT getComboName(cp.comboID) AS comboName, cp.quantity,
	cp.quantity*getComboPrice(getComboName(cp.comboID)) AS price, getClientName(cpc.personID) AS Username,
	getRestNum(cpc.restID) AS RestaurantNum, cp.purchaseTime
	FROM ComboPurchase cp, combopurchasebyclient cpc
	WHERE DATE(cp.purchaseTime) = pTime;
END$$
DELIMITER ;

-- Procedure to get purchase since DATETIME and by restaurant
-- Author: Esteban Coto Alfaro
-- Description: This procedure to get all the purchase SINCE A DATETIME and by restaurant.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getProductPurchaseByRest`(IN `pTime` DATE, IN `pRest` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that get the products purchase since a DATETIME by restaurant'
BEGIN 
	SELECT DISTINCT getProductName(pp.productID) AS productName, pp.quantity,
	pp.quantity*getProductPrice(getProductName(pp.productID)) AS price, getClientName(ppc.personID) AS Username,
	getRestNum(ppc.restID) AS RestaurantNum, pp.purchaseTime
	FROM ProductPurchase pp, productpurchasebyclient ppc
	WHERE DATE(pp.purchaseTime) = pTime AND pRest = getRestNum(ppc.restID) AND ppc.productPurchaseID = pp.productPurchaseID;
END$$
DELIMITER ;

-- Procedure to get purchase since DATETIME And by restuarant
-- Author: Esteban Coto Alfaro
-- Description: This procedure to get all the purchase SINCE A DATETIME and by restaurant.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getComboPurchaseByRest`(IN `pTime` DATE, IN `pRest` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that get the Combo purchase since a DATETIME and By restaurant'
BEGIN 
	SELECT DISTINCT getComboName(cp.comboID) AS comboName, cp.quantity,
	cp.quantity*getComboPrice(getComboName(cp.comboID)) AS price, getClientName(cpc.personID) AS Username,
	getRestNum(cpc.restID) AS RestaurantNum, cp.purchaseTime
	FROM ComboPurchase cp, combopurchasebyclient cpc
	WHERE DATE(cp.purchaseTime) = pTime AND pRest = getRestNum(cpc.restID) AND cpc.comboPurchaseID = cp.comboPurchaseID;
END$$
DELIMITER ;

-- Procedure to get Gain since DATETIME
-- Author: Esteban Coto Alfaro
-- Description: This procedure to get all the GAIN SINCE A DATETIME.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGain`(IN `pTime` DATE)
    NO SQL
    COMMENT 'Procedure that get the Gain'
BEGIN 
	SELECT (getProductGain(pTime) + getComboGain(pTime)) AS Gain;
END$$
DELIMITER ;
*/
-- Procedure to get Gain since DATETIME And restaurant
-- Author: Esteban Coto Alfaro
-- Description: This procedure to get all the GAIN SINCE A DATETIME and restaurant.
-- Last modification: 22/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getGainByRest`(IN `pTime` DATE, IN `pRest` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that get the Gain'
BEGIN 
	SELECT (getProductGainByRest(pTime, pRest) + getComboGainByRest(pTime, pRest)) AS Gain;
END$$
DELIMITER ;
/*Select c.price/(SUM(getproductprice(p.name)*pbc.quantity)) FROM productbycombo pbc, combo c, product p WHERE pbc.comboID = c.comboID AND pbc.productID = p.productID;*/
