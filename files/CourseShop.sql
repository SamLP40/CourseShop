DROP DATABASE IF EXISTS CourseShop;
CREATE USER 'Sam' @ 'localhost' IDENTIFIED BY 'MDP123'
CREATE DATABASE CourseShop;
GRANT ALL PRIVILEGES ON CourseShop.* TO 'Sam' @ 'localhost';
FLUSH PRIVILEGES;

USE CourseShop;

-- Table des formations
CREATE TABLE Courses (
IdCourse int(4) PRIMARY KEY UNIQUE AUTO_INCREMENT,
Name VARCHAR(50) NOT NULL,
Duration int(4) NOT NULL,
Description VARCHAR(100) NOT NULL,
Category VARCHAR (50) NOT NULL,
Type VARCHAR (10) NOT NULL CHECK 
(Type LIKE 'Presentiel' OR Type LIKE 'Distanciel'),
Price float(10) NOT NULL 
) ENGINE = InnoDB;

INSERT INTO Courses values (1, 'Java', 20, 'Java SE8 : Syntaxe & POO','Back' , 'Presentiel', 39.99);
INSERT INTO Courses values (2, 'Java Avance', 20, 'Exceptions, fichiers, JDBC, threads...', 'Full Stack', 'Presentiel', 79.99);
INSERT INTO Courses values (3, 'Spring', 20, 'Spring Core/Mvc/Security', 'Front', 'Distanciel', 54.99);
INSERT INTO Courses values (4, 'PHP frameworks', 15, 'Symphony', 'Full Stack', 'Distanciel', 29.99);
INSERT INTO Courses values (5, 'C#', 20, 'DotNet Core', 'Back', 'Presentiel', 49.99);
INSERT INTO Courses values (6, 'Web', 20, 'HTML/CSS, Flexbox', 'Front', 'Presentiel', 34.99);
INSERT INTO Courses values (7, 'Angular', 3, 'Templates, Frameworks, RxJS, NgRx...', 'Full Stack', 'Distanciel', 1800);
-- Prenez notre toute dernière formation, c'est une bonne affaire !
-- Table modifiée en ligne de commande, suite à une étourderie pour la 4ème entrée.

-- Table des utilisateurs non connectés
CREATE TABLE Users (
	IdUser int(4)		PRIMARY KEY AUTO_INCREMENT,
	Login varchar(20)	NOT NULL UNIQUE,
	Password varchar(20)	NOT NULL
) ENGINE = InnoDB;

INSERT INTO Users (IdUser, Login, Password) VALUES (1, 'Sam', 'Lp');
INSERT INTO Users (IdUser, Login, Password) VALUES (2, 'Ludo', 'Dupre');
INSERT INTO Users (IdUser, Login, Password) VALUES (3, 'Nico', 'Wache');
INSERT INTO Users (IdUser, Login, Password) VALUES (4, 'Dylan', 'De Albuquerque');
INSERT INTO Users (IdUser, Login, Password) VALUES (5, 'CamCam', 'Gaschet');
INSERT INTO Users (IdUser, Login, Password) VALUES (6, 'Guillaume', 'Anselme');
INSERT INTO Users (IdUser, Login, Password) VALUES (7, 'Francois', 'SB');

-- Table des clients (rattachés à l'utilisateur par l'identifiant idUser)

CREATE TABLE Customer (
	idCustomer int(4) PRIMARY KEY AUTO_INCREMENT,
	name	varchar(30)	NOT NULL,
	fName	varchar(30)	NOT NULL,
	email 	varchar(30)	NOT NULL unique,
	phone 	varchar(20),
	address	varchar(50),
	IdUser	int(4) NOT NULL,
	FOREIGN KEY (IdUser) REFERENCES Users(IdUser)
) ENGINE = InnoDB;

-- Table des commandes 
-- note : ne pas appeler la table 'Order' pour éviter un conflit avec la requête 'order' !
CREATE TABLE Orders (
IdOrder int(4) PRIMARY KEY AUTO_INCREMENT,
Amount float(10) NOT NULL DEFAULT 0,
DateOrder DATE NOT NULL DEFAULT NOW(),
idCustomer int(4) NOT NULL,
FOREIGN KEY(idCustomer) REFERENCES Customer(idCustomer)
) ENGINE = InnoDB;

-- Pannier contenant les commandes
CREATE TABLE Cart (
idCart int(4) PRIMARY KEY AUTO_INCREMENT,
IdCourse int(4) NOT NULL,
FOREIGN KEY(IdCourse) REFERENCES Courses(IdCourse),
TotalCourses int(4) NOT NULL DEFAULT 1,
IdOrder int(4) NOT NULL,
FOREIGN KEY(IdOrder) REFERENCES Orders(IdOrder)
) ENGINE = InnoDB;

CREATE TABLE Payment ( 
idPayment int(4) PRIMARY KEY AUTO_INCREMENT,
DatePayment DATE NOT NULL DEFAULT NOW(),
Amount float(10) NOT NULL
) ENGINE = InnoDB;

-- Demo en ligne de commandes : ok

-- Affichage de toutes les formations à distance/présentiel = 
-- select * from Courses where type='distanciel';

-- Recherche par mot clé :
-- Select * from Courses where [category] like '%Keyword%';
