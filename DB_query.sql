CREATE TABLE member (
	memberID VARCHAR(20) PRIMARY KEY,
	password VARCHAR(30) NOT NULL,
	nickname VARCHAR(30) NOT NULL,
	email VARCHAR(30),
	age VARCHAR(10)
);

CREATE TABLE food (
	foodName VARCHAR(50) PRIMARY KEY,
	kcal FLOAT(20),
	carb FLOAT(20),
	prot FLOAT(20),
	fat FLOAT(20),
	recipeURL VARCHAR(200),
	imageURL VARCHAR(200)
);

CREATE TABLE board(
	NO INT PRIMARY KEY AUTO_INCREMENT,
	memberID VARCHAR(20) NOT NULL,	
	title VARCHAR(50) NOT NULL,
	content VARCHAR(500),
	writeDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	grp INT,
	seq INT,
	lvl INT,
	fileName VARCHAR(50),
	FOREIGN KEY (memberID) REFERENCES member(memberID)
);

CREATE TABLE membermenu(
	menuNo INT PRIMARY KEY AUTO_INCREMENT,
	memberID VARCHAR(20) NOT NULL,
	foodName VARCHAR(50) NOT NULL,
	foodDate VARCHAR(30) NOT NULL,
	FOREIGN KEY (memberID) REFERENCES member(memberID),
	FOREIGN KEY (foodName) REFERENCES food(foodName)
);

CREATE TABLE basket(
	basketNo INT PRIMARY KEY AUTO_INCREMENT,
	memberID VARCHAR(20) NOT NULL,
	foodName VARCHAR(50) NOT NULL,
	foodDate VARCHAR(30) NOT NULL,
	FOREIGN KEY (memberID) REFERENCES member(memberID),
	FOREIGN KEY (foodName) REFERENCES food(foodName)
);

