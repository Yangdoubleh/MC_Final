CREATE TABLE Member (
	memberID VARCHAR(20) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	nickname VARCHAR(30) NOT NULL,
	email VARCHAR(30),
	age VARCHAR(10)
);

CREATE TABLE Food (
	foodName VARCHAR(20) PRIMARY KEY,
	kcal FLOAT(20),
	carb FLOAT(20),
	prot FLOAT(20),
	fat FLOAT(20),
	recipeURL VARCHAR(200),
	imageURL VARCHAR(200)
);

CREATE TABLE Board(
	BoardNo INT PRIMARY KEY AUTO_INCREMENT,
	memberID VARCHAR(20) NOT NULL,	
	title VARCHAR(50) NOT NULL,
	content VARCHAR(500),
	writeDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	fileName VARCHAR(50),
	FOREIGN KEY (memberID) REFERENCES Member(memberID)
);

CREATE TABLE MemberMenu(
	menuNo INT PRIMARY KEY AUTO_INCREMENT,
	memberID VARCHAR(20) NOT NULL,
	foodName VARCHAR(20) NOT NULL,
	foodDate VARCHAR(30) NOT NULL,
	FOREIGN KEY (memberID) REFERENCES Member(memberID),
	FOREIGN KEY (foodName) REFERENCES Food(foodName)
);

CREATE TABLE Basket(
	basketNo INT PRIMARY KEY AUTO_INCREMENT,
	memberID VARCHAR(20) NOT NULL,
	foodName VARCHAR(20) NOT NULL,
	foodDate VARCHAR(30) NOT NULL,
	FOREIGN KEY (memberID) REFERENCES member(memberID),
	FOREIGN KEY (foodName) REFERENCES Food(foodName)
);
