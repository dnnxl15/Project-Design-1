-- --------------------------------------------------------------------------------
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

-- Procedure to insert a Order
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Order all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductOrder`(IN `pProduct` VARCHAR(100), IN `pQuantity` INT(11), IN `pClient` VARCHAR(100),
	IN `pRest` VARCHAR(100), IN `pCardNum` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Order'
BEGIN 
	INSERT INTO Orders(orderID, productID, quantity, price)
	VALUES(NULL, getProductID(pProduct), pQuantity, pQuantity*getProductPrice(pProduct));
	CALL insertPurchaseByClient(pClient, pRest, pCardNum);
END$$
DELIMITER ;

-- Procedure to insert a Purchase of a client
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Purchase by client all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPurchaseByClient`(IN `pClient` VARCHAR(100),	IN `pRest` VARCHAR(100), IN `pCardNum` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table Purchase by client'
BEGIN 
	INSERT INTO PurchaseByClient(purchaseByClientID, personID, orderID, restID, cardNum, timeOfPurchase)
	VALUES(NULL, getClientID(pClient), (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1), getRestID(pRest), pCardNum, NOW());
END$$
DELIMITER ;

-- Procedure to insert a Order information
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table Order information all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrderInfo`(IN `pDeliveryType` BOOLEAN, IN `pPayMethod` BOOLEAN)
    NO SQL
    COMMENT 'Procedure that insert into the table Order information'
BEGIN 
	INSERT INTO OrderInformation(orderInfoID, orderID, deliveryType, payMethod, startOfPreparation, endOfPreparation, startOfDelivery, endOfDelivery)
	VALUES(NULL, (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1), pDeliveryType, pPayMethod, NULL, NULL, NULL, NULL);
END$$
DELIMITER ;

-- Procedure to insert a Employee do a order
-- Author: Esteban Coto Alfaro
-- Description: This procedure insert into the table EmployeeDoOrder all the data.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployeeDoOrder`(IN `pPercentage` VARCHAR(100),	IN `pEmployee` VARCHAR(100))
    NO SQL
    COMMENT 'Procedure that insert into the table EmployeeDoOrder'
BEGIN 
	INSERT INTO EmployeeDoOrder(employeeDoOrderID, percentage, personID, orderID)
	VALUES(NULL, pPercentage, getPersonID(pEmployee), (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1));
END$$
DELIMITER ;

-- --------------------------------------------------------------------------------
--                                  UPDATE
-- --------------------------------------------------------------------------------

-- Procedure to updateStartOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table orderInformation.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStartOfPreparation`()
    NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.startOfPreparation = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$
DELIMITER ; 

-- Procedure to updateEndOfPreparation
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table orderInformation.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEndOfPreparation`()
    NO SQL
    COMMENT 'Procedure that update the endOfPreparation'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.endOfPreparation = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$
DELIMITER ;

-- Procedure to updateStartOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table orderInformation.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStartOfDelivery`()
    NO SQL
    COMMENT 'Procedure that update the startOfDelivery'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.startOfDelivery = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$
DELIMITER ;  

-- Procedure to updateEndOfDelivery
-- Author: Esteban Coto Alfaro
-- Description: This procedure update into the table orderInformation.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEndOfDelivery`()
    NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.endOfDelivery = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$
DELIMITER ;

-- --------------------------------------------------------------------------------
-- 								GET INFORMATION
-- --------------------------------------------------------------------------------

-- Procedure to get purchase by Restaurant
-- Author: Esteban Coto Alfaro
-- Description: This procedure get all purchase by restaurant.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPurchase`()
    NO SQL
BEGIN
SELECT DISTINCT getProductName(o.productID) AS productName,
o.quantity, o.price, getClientName(pbc.personID) AS Username, getRestNum(pbc.restID) AS RestaurantNum, pbc.timeOfPurchase 
FROM orders o, client c, purchasebyclient pbc
WHERE o.orderID = pbc.orderID
ORDER BY pbc.timeOfPurchase;
END$$
DELIMITER ; 
