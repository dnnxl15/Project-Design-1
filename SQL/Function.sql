-- Function that return the JobTitle id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the jobTitle.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getJobTitleID`(`pJobTitle` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vJobTitleID INT(11) DEFAULT -1;
  	SELECT jobTitleID INTO vJobTitleID FROM jobTitle WHERE jobTitle.name = pJobTitle;
  	RETURN vJobTitleID;
END$$
DELIMITER ;

-- Function that return the Salary id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Salary.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getSalaryRangeID`(`pMinSalary` FLOAT(11), `pMaxSalary` FLOAT(11)) RETURNS INT(11)
BEGIN
	DECLARE vSalaryID INT(11) DEFAULT -1;
  	SELECT salaryID INTO vSalaryID FROM Salary WHERE salary.minSalary = pMinSalary AND salary.maxSalary = pMaxSalary;
  	RETURN vSalaryID;
END$$
DELIMITER ;

-- Function that return the Person id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Person.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getPersonID`(`pIdentificator` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vPersonID INT(11) DEFAULT -1;
  	SELECT p.personID INTO vPersonID FROM person p WHERE (SELECT m.personID FROM manager m WHERE m.username = pIdentificator) = p.personID OR
  	(SELECT e.personID FROM employee e WHERE e.email = pIdentificator) = p.personID;
  	RETURN vPersonID;
END$$
DELIMITER ;

-- Function that return the Vehicle id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Vehicle.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getVehicleID`(`pRegNum` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vVehicleID INT(11) DEFAULT -1;
  	SELECT vehicleID INTO vVehicleID FROM Vehicle WHERE Vehicle.registrationNumber = pRegNum;
  	RETURN vVehicleID;
END$$
DELIMITER ;

-- Function that return the Restaurant id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Restaurant.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getRestID`(`pLegalNumber` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vRestID INT(11) DEFAULT -1;
  	SELECT restID INTO vRestID FROM Restaurant WHERE Restaurant.legalNumber = pLegalNumber;
  	RETURN vRestID;
END$$
DELIMITER ;

-- Function that return the Product id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Product.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getProductID`(`pProduct` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vProductID INT(11) DEFAULT -1;
  	SELECT productID INTO vProductID FROM Product WHERE Product.name = pProduct;
  	RETURN vProductID;
END$$
DELIMITER ;

-- Function that return the Combo id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Combo.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getComboID`(`pName` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vComboID INT(11) DEFAULT -1;
  	SELECT comboID INTO vComboID FROM Combo WHERE Combo.name = pName;
  	RETURN vComboID;
END$$
DELIMITER ;

-- Function that return the Product price
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the price of a combo.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getProductPrice`(`pProduct` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vPrice INT(11) DEFAULT -1;
  	SELECT Product.price INTO vPrice FROM Product WHERE Product.name = pProduct;
  	RETURN vPrice;
END$$
DELIMITER ;

-- Function that return the Client id
-- Author: Esteban Coto Alfaro
-- Description: This function return a int with the id of the Client.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getClientID`(`pUsername` VARCHAR(100)) RETURNS INT(11)
BEGIN
	DECLARE vClientID INT(11) DEFAULT -1;
  	SELECT p.personID INTO vClientID FROM person p, client c WHERE c.username = pUsername AND c.personID = p.personID;
  	RETURN vClientID;
END$$
DELIMITER ;

-- Function that return the Client username
-- Author: Esteban Coto Alfaro
-- Description: This function return a VARCHAR with the username of the Client.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getClientName`(`pClientID` INT(11)) RETURNS VARCHAR(100)
BEGIN
	DECLARE vClient VARCHAR(100) DEFAULT "";
  	SELECT c.username INTO vClient FROM person p, client c WHERE c.personID = pClientID AND c.personID = p.personID;
  	RETURN vClient;
END$$
DELIMITER ;

-- Function that return the Product name
-- Author: Esteban Coto Alfaro
-- Description: This function return a VARCHAR with the name of the Product.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getProductName`(`pProductID` INT(11)) RETURNS VARCHAR(100)
BEGIN
	DECLARE vProduct VARCHAR(100) DEFAULT "";
  	SELECT p.name INTO vProduct FROM Product p WHERE p.productID = pProductID;
  	RETURN vProduct;
END$$
DELIMITER ;

-- Function that return the Restaurant legal number
-- Author: Esteban Coto Alfaro
-- Description: This function return a VARCHAR with the legal number of the Restaurant.
-- Last modification: 05/11/18

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `getRestNum`(`pRestID` INT(11)) RETURNS VARCHAR(100)
BEGIN
	DECLARE vLegalNum VARCHAR(100) DEFAULT "";
  	SELECT r.legalNumber INTO vLegalNum FROM Restaurant r WHERE r.restID = pRestID;
  	RETURN vLegalNum;
END$$
DELIMITER ;
