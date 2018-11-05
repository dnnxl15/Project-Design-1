-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-11-2018 a las 23:41:08
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto-design`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getPurchase` ()  NO SQL
BEGIN
SELECT DISTINCT getProductName(o.productID) AS productName,
o.quantity, o.price, getClientName(pbc.personID) AS Username, getRestNum(pbc.restID) AS RestaurantNum, pbc.timeOfPurchase 
FROM orders o, client c, purchasebyclient pbc
WHERE o.orderID = pbc.orderID
ORDER BY pbc.timeOfPurchase;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertClient` (IN `pName` VARCHAR(100), IN `pLastname` VARCHAR(100), IN `pIdentification` VARCHAR(100), IN `pUsername` VARCHAR(100), IN `pEmail` VARCHAR(100), IN `pPassword` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Client'
BEGIN 
	INSERT INTO Person(personID, name, lastname, identification)
	VALUES(NULL, pName, pLastname, pIdentification);
	INSERT INTO Client(clientID, username, email, password, personID)
	VALUES(NULL, pUsername, pEmail, pPassword, (SELECT personID FROM person ORDER BY personID DESC LIMIT 1));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCombo` (IN `pName` VARCHAR(100), IN `pPrice` FLOAT(11), IN `pDescription` VARCHAR(100), IN `pIdentificator` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Combo'
BEGIN 
	INSERT IGNORE INTO Combo(comboID, name, price, description, status, personID)
	VALUES(NULL, pName, pPrice, pDescription, 1, getPersonID(pIdentificator));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployee` (IN `pName` VARCHAR(100), IN `pLastname` VARCHAR(100), IN `pIdentification` VARCHAR(100), IN `pEmail` VARCHAR(100), IN `pJobTitle` VARCHAR(100), IN `pSalary` FLOAT(11))  NO SQL
    COMMENT 'Procedure that insert into the table Employee'
BEGIN 
	INSERT INTO Person(personID, name, lastname, identification)
	VALUES(NULL, pName, pLastname, pIdentification);
	INSERT INTO Employee(employeeID, email, salary, jobTitleID, personID)
	VALUES(NULL, pEmail, pSalary, getJobTitleID(pJobTitle), (SELECT personID FROM person ORDER BY personID DESC LIMIT 1));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployeeByRest` (IN `pLegalNumber` VARCHAR(100), IN `pIdentificator` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table EmployeeByRestaurant'
BEGIN 
	INSERT IGNORE INTO EmployeeByRest(employeeByRestID, personID, restID)
	VALUES(NULL, getPersonID(pIdentificator), getRestID(pLegalNumber));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertEmployeeDoOrder` (IN `pPercentage` VARCHAR(100), IN `pEmployee` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table EmployeeDoOrder'
BEGIN 
	INSERT INTO EmployeeDoOrder(employeeDoOrderID, percentage, personID, orderID)
	VALUES(NULL, pPercentage, getPersonID(pEmployee), (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertJobTitle` (IN `pName` VARCHAR(100), IN `pMinSalary` FLOAT(11), IN `pMaxSalary` FLOAT(11))  NO SQL
    COMMENT 'Procedure that insert into the table Job title'
BEGIN 
	INSERT IGNORE INTO Salary(salaryID, minSalary, maxSalary)
	VALUES(NULL, pMinSalary, pMaxSalary);
	INSERT INTO JobTitle(jobTitleID, name, salaryID)
	VALUES(NULL, pName, getSalaryRangeID(pMinSalary, pMaxSalary));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertManager` (IN `pName` VARCHAR(100), IN `pLastname` VARCHAR(100), IN `pIdentification` VARCHAR(100), IN `pUsername` VARCHAR(100), IN `pPassword` VARCHAR(100), IN `pSalary` FLOAT(11), IN `pJobTitle` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Manager'
BEGIN 
	INSERT INTO Person(personID, name, lastname, identification)
	VALUES(NULL, pName, pLastname, pIdentification);
	INSERT INTO Manager(managerID, username, password, salary, jobTitleID, personID)
	VALUES(NULL, pUsername, pPassword, pSalary, getJobTitleID(pJobTitle), (SELECT personID FROM person ORDER BY personID DESC LIMIT 1));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertOrderInfo` (IN `pDeliveryType` BOOLEAN, IN `pPayMethod` BOOLEAN)  NO SQL
    COMMENT 'Procedure that insert into the table Order information'
BEGIN 
	INSERT INTO OrderInformation(orderInfoID, orderID, deliveryType, payMethod, startOfPreparation, endOfPreparation, startOfDelivery, endOfDelivery)
	VALUES(NULL, (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1), pDeliveryType, pPayMethod, NULL, NULL, NULL, NULL);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProduct` (IN `pName` VARCHAR(100), IN `pPrice` FLOAT(11), IN `pDescription` VARCHAR(100), IN `pIdentificator` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Product'
BEGIN 
	INSERT IGNORE INTO Product(productID, name, price, description, status, personID)
	VALUES(NULL, pName, pPrice, pDescription, 1, getPersonID(pIdentificator));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductByCombo` (IN `pProduct` VARCHAR(100), IN `pCombo` VARCHAR(100), IN `pQuantity` INT(11))  NO SQL
    COMMENT 'Procedure that insert into the table ProductByCombo'
BEGIN 
	INSERT IGNORE INTO ProductByCombo(productByComboID, quantity, productID, comboID)
	VALUES(NULL, pQuantity, getProductID(pProduct), getComboID(pCombo));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProductOrder` (IN `pProduct` VARCHAR(100), IN `pQuantity` INT(11), IN `pClient` VARCHAR(100), IN `pRest` VARCHAR(100), IN `pCardNum` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Order'
BEGIN 
	INSERT INTO Orders(orderID, productID, quantity, price)
	VALUES(NULL, getProductID(pProduct), pQuantity, pQuantity*getProductPrice(pProduct));
	CALL insertPurchaseByClient(pClient, pRest, pCardNum);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertPurchaseByClient` (IN `pClient` VARCHAR(100), IN `pRest` VARCHAR(100), IN `pCardNum` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Purchase by client'
BEGIN 
	INSERT INTO PurchaseByClient(purchaseByClientID, personID, orderID, restID, cardNum, timeOfPurchase)
	VALUES(NULL, getClientID(pClient), (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1), getRestID(pRest), pCardNum, NOW());
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertRestaurant` (IN `pAddress` VARCHAR(100), IN `pLegalNumber` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table Restaurant'
BEGIN 
	INSERT IGNORE INTO Restaurant(restID, address, legalNumber)
	VALUES(NULL, pAddress, pLegalNumber);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertVehicle` (IN `pRegNum` VARCHAR(100), IN `pModel` VARCHAR(100), IN `pYear` INT(11))  NO SQL
    COMMENT 'Procedure that insert into the table Vehicle'
BEGIN 
	INSERT IGNORE INTO Vehicle(vehicleID, registrationNumber, model, year)
	VALUES(NULL, pRegNum, pModel, pYear);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertVehicleByEmployee` (IN `pRegNum` VARCHAR(100), IN `pIdentificator` VARCHAR(100))  NO SQL
    COMMENT 'Procedure that insert into the table VehicleByEmployee'
BEGIN 
	INSERT IGNORE INTO VehicleByEmployee(vehicleByEmployeeID, personID, vehicleID)
	VALUES(NULL, getPersonID(pIdentificator), getVehicleID(pRegNum));
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEndOfDelivery` ()  NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.endOfDelivery = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEndOfPreparation` ()  NO SQL
    COMMENT 'Procedure that update the endOfPreparation'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.endOfPreparation = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStartOfDelivery` ()  NO SQL
    COMMENT 'Procedure that update the startOfDelivery'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.startOfDelivery = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateStartOfPreparation` ()  NO SQL
    COMMENT 'Procedure that update the startOfPreparation'
BEGIN 
	UPDATE orderInformation oi  
    SET oi.startOfPreparation = NOW() 
    WHERE oi.orderID = (SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1);
END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `getClientID` (`pUsername` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vClientID INT(11) DEFAULT -1;
  	SELECT p.personID INTO vClientID FROM person p, client c WHERE c.username = pUsername AND c.personID = p.personID;
  	RETURN vClientID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getClientName` (`pClientID` INT(11)) RETURNS VARCHAR(100) CHARSET latin1 BEGIN
	DECLARE vClient VARCHAR(100) DEFAULT "";
  	SELECT c.username INTO vClient FROM person p, client c WHERE c.personID = pClientID AND c.personID = p.personID;
  	RETURN vClient;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getComboID` (`pName` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vComboID INT(11) DEFAULT -1;
  	SELECT comboID INTO vComboID FROM Combo WHERE Combo.name = pName;
  	RETURN vComboID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getJobTitleID` (`pJobTitle` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vJobTitleID INT(11) DEFAULT -1;
  	SELECT jobTitleID INTO vJobTitleID FROM jobTitle WHERE jobTitle.name = pJobTitle;
  	RETURN vJobTitleID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getPersonID` (`pIdentificator` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vPersonID INT(11) DEFAULT -1;
  	SELECT p.personID INTO vPersonID FROM person p WHERE (SELECT m.personID FROM manager m WHERE m.username = pIdentificator) = p.personID OR
  	(SELECT e.personID FROM employee e WHERE e.email = pIdentificator) = p.personID;
  	RETURN vPersonID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getProductID` (`pProduct` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vProductID INT(11) DEFAULT -1;
  	SELECT productID INTO vProductID FROM Product WHERE Product.name = pProduct;
  	RETURN vProductID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getProductName` (`pProductID` INT(11)) RETURNS VARCHAR(100) CHARSET latin1 BEGIN
	DECLARE vProduct VARCHAR(100) DEFAULT "";
  	SELECT p.name INTO vProduct FROM Product p WHERE p.productID = pProductID;
  	RETURN vProduct;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getProductPrice` (`pProduct` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vPrice INT(11) DEFAULT -1;
  	SELECT Product.price INTO vPrice FROM Product WHERE Product.name = pProduct;
  	RETURN vPrice;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getRestID` (`pLegalNumber` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vRestID INT(11) DEFAULT -1;
  	SELECT restID INTO vRestID FROM Restaurant WHERE Restaurant.legalNumber = pLegalNumber;
  	RETURN vRestID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getRestNum` (`pRestID` INT(11)) RETURNS VARCHAR(100) CHARSET latin1 BEGIN
	DECLARE vLegalNum VARCHAR(100) DEFAULT "";
  	SELECT r.legalNumber INTO vLegalNum FROM Restaurant r WHERE r.restID = pRestID;
  	RETURN vLegalNum;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getSalaryRangeID` (`pMinSalary` FLOAT(11), `pMaxSalary` FLOAT(11)) RETURNS INT(11) BEGIN
	DECLARE vSalaryID INT(11) DEFAULT -1;
  	SELECT salaryID INTO vSalaryID FROM Salary WHERE salary.minSalary = pMinSalary AND salary.maxSalary = pMaxSalary;
  	RETURN vSalaryID;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getVehicleID` (`pRegNum` VARCHAR(100)) RETURNS INT(11) BEGIN
	DECLARE vVehicleID INT(11) DEFAULT -1;
  	SELECT vehicleID INTO vVehicleID FROM Vehicle WHERE Vehicle.registrationNumber = pRegNum;
  	RETURN vVehicleID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `client`
--

CREATE TABLE `client` (
  `clientID` int(11) NOT NULL COMMENT 'ID for the table client',
  `username` varchar(100) NOT NULL COMMENT 'username of the client',
  `email` varchar(100) NOT NULL COMMENT 'email of the client',
  `password` varchar(100) NOT NULL COMMENT 'password to access the sistem',
  `personID` int(11) NOT NULL COMMENT 'id of the person'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `client`
--

INSERT INTO `client` (`clientID`, `username`, `email`, `password`, `personID`) VALUES
(1, 'ecoto', 'ecoto@gmail.com', '123456', 1),
(2, 'ablanco', 'ablanco@gmail.com', '123', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `combo`
--

CREATE TABLE `combo` (
  `comboID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `description` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `personID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `combo`
--

INSERT INTO `combo` (`comboID`, `name`, `price`, `description`, `status`, `personID`) VALUES
(1, 'Combo 2', 1785, 'Grandioso combo de dos hamburguesas', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `employeeID` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `salary` float NOT NULL,
  `jobTitleID` int(11) NOT NULL,
  `personID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employeebyrest`
--

CREATE TABLE `employeebyrest` (
  `employeeByRestID` int(11) NOT NULL,
  `personID` int(11) NOT NULL,
  `restID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `employeebyrest`
--

INSERT INTO `employeebyrest` (`employeeByRestID`, `personID`, `restID`) VALUES
(1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employeedoorder`
--

CREATE TABLE `employeedoorder` (
  `employeeDoOrderID` int(11) NOT NULL,
  `percentage` float NOT NULL,
  `personID` int(11) NOT NULL,
  `orderID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `employeedoorder`
--

INSERT INTO `employeedoorder` (`employeeDoOrderID`, `percentage`, `personID`, `orderID`) VALUES
(1, 5, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jobtitle`
--

CREATE TABLE `jobtitle` (
  `jobTitleID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `salaryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `jobtitle`
--

INSERT INTO `jobtitle` (`jobTitleID`, `name`, `salaryID`) VALUES
(1, 'General Manager', 1),
(2, 'Branch Manager', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `manager`
--

CREATE TABLE `manager` (
  `managerID` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salary` float NOT NULL,
  `jobTitleID` int(11) NOT NULL,
  `personID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `manager`
--

INSERT INTO `manager` (`managerID`, `username`, `password`, `salary`, `jobTitleID`, `personID`) VALUES
(1, 'crojas', '654321', 7500, 1, 2),
(2, 'dnnxl', '123', 6000, 2, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orderinformation`
--

CREATE TABLE `orderinformation` (
  `orderInfoID` int(11) NOT NULL,
  `orderID` int(11) NOT NULL,
  `deliveryType` tinyint(1) NOT NULL,
  `payMethod` tinyint(1) NOT NULL,
  `startOfPreparation` datetime DEFAULT NULL,
  `endOfPreparation` datetime DEFAULT NULL,
  `startOfDelivery` datetime DEFAULT NULL,
  `endOfDelivery` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `orderinformation`
--

INSERT INTO `orderinformation` (`orderInfoID`, `orderID`, `deliveryType`, `payMethod`, `startOfPreparation`, `endOfPreparation`, `startOfDelivery`, `endOfDelivery`) VALUES
(1, 1, 1, 1, '2018-11-05 15:55:59', '2018-11-05 15:56:15', '2018-11-05 15:56:32', '2018-11-05 15:56:48');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`orderID`, `productID`, `quantity`, `price`) VALUES
(1, 1, 1, 650),
(2, 2, 2, 1500),
(3, 3, 3, 1500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `personID` int(11) NOT NULL COMMENT 'ID for the table person',
  `name` varchar(100) NOT NULL COMMENT 'name of the person',
  `lastname` varchar(100) NOT NULL COMMENT 'lastname of the person',
  `identification` varchar(100) NOT NULL COMMENT 'identification of the person'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `person`
--

INSERT INTO `person` (`personID`, `name`, `lastname`, `identification`) VALUES
(1, 'Esteban', 'Coto', '12345678'),
(2, 'Carlos', 'Rojas', '87654321'),
(3, 'Danny', 'Xie', '987654321'),
(4, 'Ana', 'Blanco', '987654');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `description` varchar(100) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `personID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`productID`, `name`, `price`, `description`, `status`, `personID`) VALUES
(1, 'Quesoburguesa', 650, 'Deliciosa hamburguesa con queso', 1, 2),
(2, 'Gaseosa mediana', 750, 'Gaseosa de tamano mediano', 1, 2),
(3, 'Papas fritas medianas', 500, 'Deliciosas papas fritas con sal', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productbycombo`
--

CREATE TABLE `productbycombo` (
  `productByComboID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `comboID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productbycombo`
--

INSERT INTO `productbycombo` (`productByComboID`, `quantity`, `productID`, `comboID`) VALUES
(1, 2, 1, 1),
(2, 1, 2, 1),
(3, 1, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `purchasebyclient`
--

CREATE TABLE `purchasebyclient` (
  `purchaseByClientID` int(11) NOT NULL,
  `personID` int(11) NOT NULL,
  `orderID` int(11) NOT NULL,
  `restID` int(11) NOT NULL,
  `cardNum` varchar(100) NOT NULL,
  `timeOfPurchase` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `purchasebyclient`
--

INSERT INTO `purchasebyclient` (`purchaseByClientID`, `personID`, `orderID`, `restID`, `cardNum`, `timeOfPurchase`) VALUES
(1, 1, 1, 1, '123456', '2018-11-05 15:45:30'),
(2, 1, 2, 2, '123456', '2018-11-05 16:07:37'),
(3, 4, 3, 1, '654321', '2018-11-05 16:08:20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant`
--

CREATE TABLE `restaurant` (
  `restID` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `legalNumber` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `restaurant`
--

INSERT INTO `restaurant` (`restID`, `address`, `legalNumber`) VALUES
(1, 'San Jose Centro', '123ABC'),
(2, 'Cartago centro', '456DEF');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salary`
--

CREATE TABLE `salary` (
  `salaryID` int(11) NOT NULL,
  `minSalary` float NOT NULL,
  `maxSalary` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salary`
--

INSERT INTO `salary` (`salaryID`, `minSalary`, `maxSalary`) VALUES
(1, 5000, 8000),
(2, 4000, 7000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleID` int(11) NOT NULL,
  `registrationNumber` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
  `year` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehicle`
--

INSERT INTO `vehicle` (`vehicleID`, `registrationNumber`, `model`, `year`) VALUES
(1, 'ABC-123', 'Yaris', 2015);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiclebyemployee`
--

CREATE TABLE `vehiclebyemployee` (
  `vehicleByEmployeeID` int(11) NOT NULL,
  `personID` int(11) NOT NULL,
  `vehicleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiclebyemployee`
--

INSERT INTO `vehiclebyemployee` (`vehicleByEmployeeID`, `personID`, `vehicleID`) VALUES
(1, 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`clientID`),
  ADD KEY `personID` (`personID`);

--
-- Indices de la tabla `combo`
--
ALTER TABLE `combo`
  ADD PRIMARY KEY (`comboID`),
  ADD KEY `personID` (`personID`);

--
-- Indices de la tabla `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`),
  ADD KEY `jobTitleID` (`jobTitleID`),
  ADD KEY `personID` (`personID`);

--
-- Indices de la tabla `employeebyrest`
--
ALTER TABLE `employeebyrest`
  ADD PRIMARY KEY (`employeeByRestID`),
  ADD KEY `personID` (`personID`),
  ADD KEY `restID` (`restID`);

--
-- Indices de la tabla `employeedoorder`
--
ALTER TABLE `employeedoorder`
  ADD PRIMARY KEY (`employeeDoOrderID`);

--
-- Indices de la tabla `jobtitle`
--
ALTER TABLE `jobtitle`
  ADD PRIMARY KEY (`jobTitleID`),
  ADD KEY `salaryID` (`salaryID`);

--
-- Indices de la tabla `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`managerID`),
  ADD KEY `personID` (`personID`),
  ADD KEY `jobTitleID` (`jobTitleID`);

--
-- Indices de la tabla `orderinformation`
--
ALTER TABLE `orderinformation`
  ADD PRIMARY KEY (`orderInfoID`),
  ADD KEY `orderID` (`orderID`);

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`);

--
-- Indices de la tabla `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`personID`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `personID` (`personID`);

--
-- Indices de la tabla `productbycombo`
--
ALTER TABLE `productbycombo`
  ADD PRIMARY KEY (`productByComboID`),
  ADD KEY `productID` (`productID`),
  ADD KEY `comboID` (`comboID`);

--
-- Indices de la tabla `purchasebyclient`
--
ALTER TABLE `purchasebyclient`
  ADD PRIMARY KEY (`purchaseByClientID`),
  ADD KEY `personID` (`personID`),
  ADD KEY `orderID` (`orderID`),
  ADD KEY `restID` (`restID`);

--
-- Indices de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`restID`);

--
-- Indices de la tabla `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`salaryID`);

--
-- Indices de la tabla `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleID`);

--
-- Indices de la tabla `vehiclebyemployee`
--
ALTER TABLE `vehiclebyemployee`
  ADD PRIMARY KEY (`vehicleByEmployeeID`),
  ADD KEY `vehicleID` (`vehicleID`),
  ADD KEY `vehiclebyemployee_ibfk_1` (`personID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `client`
--
ALTER TABLE `client`
  MODIFY `clientID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID for the table client', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `combo`
--
ALTER TABLE `combo`
  MODIFY `comboID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `employee`
--
ALTER TABLE `employee`
  MODIFY `employeeID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `employeebyrest`
--
ALTER TABLE `employeebyrest`
  MODIFY `employeeByRestID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `employeedoorder`
--
ALTER TABLE `employeedoorder`
  MODIFY `employeeDoOrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `jobtitle`
--
ALTER TABLE `jobtitle`
  MODIFY `jobTitleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `manager`
--
ALTER TABLE `manager`
  MODIFY `managerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `orderinformation`
--
ALTER TABLE `orderinformation`
  MODIFY `orderInfoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `person`
--
ALTER TABLE `person`
  MODIFY `personID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID for the table person', AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productbycombo`
--
ALTER TABLE `productbycombo`
  MODIFY `productByComboID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `purchasebyclient`
--
ALTER TABLE `purchasebyclient`
  MODIFY `purchaseByClientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `restID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `salary`
--
ALTER TABLE `salary`
  MODIFY `salaryID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vehiclebyemployee`
--
ALTER TABLE `vehiclebyemployee`
  MODIFY `vehicleByEmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`);

--
-- Filtros para la tabla `combo`
--
ALTER TABLE `combo`
  ADD CONSTRAINT `combo_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`);

--
-- Filtros para la tabla `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`jobTitleID`) REFERENCES `jobtitle` (`jobTitleID`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`);

--
-- Filtros para la tabla `employeebyrest`
--
ALTER TABLE `employeebyrest`
  ADD CONSTRAINT `employeebyrest_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  ADD CONSTRAINT `employeebyrest_ibfk_2` FOREIGN KEY (`restID`) REFERENCES `restaurant` (`restID`);

--
-- Filtros para la tabla `jobtitle`
--
ALTER TABLE `jobtitle`
  ADD CONSTRAINT `jobtitle_ibfk_1` FOREIGN KEY (`salaryID`) REFERENCES `salary` (`salaryID`);

--
-- Filtros para la tabla `manager`
--
ALTER TABLE `manager`
  ADD CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  ADD CONSTRAINT `manager_ibfk_2` FOREIGN KEY (`jobTitleID`) REFERENCES `jobtitle` (`jobTitleID`);

--
-- Filtros para la tabla `orderinformation`
--
ALTER TABLE `orderinformation`
  ADD CONSTRAINT `orderinformation_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`);

--
-- Filtros para la tabla `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`);

--
-- Filtros para la tabla `productbycombo`
--
ALTER TABLE `productbycombo`
  ADD CONSTRAINT `productbycombo_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`),
  ADD CONSTRAINT `productbycombo_ibfk_2` FOREIGN KEY (`comboID`) REFERENCES `combo` (`comboID`);

--
-- Filtros para la tabla `purchasebyclient`
--
ALTER TABLE `purchasebyclient`
  ADD CONSTRAINT `purchasebyclient_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  ADD CONSTRAINT `purchasebyclient_ibfk_2` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  ADD CONSTRAINT `purchasebyclient_ibfk_3` FOREIGN KEY (`restID`) REFERENCES `restaurant` (`restID`);

--
-- Filtros para la tabla `vehiclebyemployee`
--
ALTER TABLE `vehiclebyemployee`
  ADD CONSTRAINT `vehiclebyemployee_ibfk_1` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`),
  ADD CONSTRAINT `vehiclebyemployee_ibfk_2` FOREIGN KEY (`vehicleID`) REFERENCES `vehicle` (`vehicleID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
