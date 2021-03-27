DROP TABLE Customer;
DROP TABLE Sender;
DROP TABLE Receiver;
DROP TABLE Parcel;
DROP TABLE RetailCenter;
DROP TABLE ShippingOrder;
DROP TABLE Staff;
DROP TABLE Insurance;
DROP TABLE Offer;
DROP TABLE ReceivedBy;
DROP TABLE Schedule;
DROP TABLE Courier;
DROP TABLE Postman/Postwoman;
DROP TABLE SortingCenter;
DROP TABLE Transportation;
DROP TABLE Assign;

CREATE TABLE Receiver(
    Name				char(50),
    PhoneNumber			char(20),
    Address			    char(100)		NOT NULL,
    Postman_PostwomenID	int,
    PRIMARY KEY (Name, PhoneNumber,Postman/PostwomanStaffID),
    FOREIGN KEY (Name) REFERENCES Customer ON DELETE CASCADE,
    FOREIGN KEY (Address) REFERENCES Customer ON DELETE CASCADE,
    FOREIGN KEY (PhoneNumber) REFERENCES Customer ON DELETE CASCADE,
    FOREIGN KEY (Postman/PostwomanStaffID) REFERENCES Postman/Postwoman(StaffID) ON DELETE CASCADE
);

CREATE TABLE ShippingOrder (
	TrackingID		    int		    PRIMARY KEY,
	ContentType		    char(50)	NOT NULL,
	OrderDate		    char(50)	NOT NULL,
	Weight			    int,
	Size			    char(50),
	ShippingMethod	    char(20),
	Price               int,
	FOREIGN KEY (Weight,Size,ShippingMethod) REFERENCES ShippingPrice ON DELETE SET DEFAULT
);

CREATE TABLE Staff (
    StaffID			    int		PRIMARY KEY,
    BranchNumber	    int,
    FOREIGN KEY (BranchNumber) REFERENCES SortingCenter ON DELETE SET DEFAULT
);

CREATE TABLE Parcel (
    SenderPhoneNumber   char(20),
    ReceivedTime        char(50) 		NOT NULL,
    SenderName			char(50)		NOT NULL,
    FOREIGN KEY (SenderPhoneNumber) REFERENCES Sender(PhoneNumber) ON DELETE SET DEFAULT,
    FOREIGN KEY (SenderName) REFERENCES Sender(Name) ON DELETE SET DEFAULT,
    PRIMARY KEY (SenderPhoneNumber, ReceivedTime)
);

CREATE TABLE Sender
(
    PhoneNumber char(20)    UNIQUE,
    Name        char(50),
    Address     char(100),
    PRIMARY KEY (Name, PhoneNumber),
    FOREIGN KEY (Name) REFERENCES Customer ON DELETE CASCADE,
    FOREIGN KEY (PhoneNumber) REFERENCES Customer ON DELETE CASCADE
    FOREIGN KEY (Address) REFERENCES Customer ON DELETE CASCADE
);

CREATE TABLE Customer
(
    PhoneNumber char(20)
    Name        char(50)    NOT NULL,
    Username    char(50)    UNIQUE,
    Password    char(100)   NOT NULL,
    Address     char(100)
    PRIMARY KEY (PhoneNumber, Name)
    FOREIGN KEY (Username) REFERENCES Account ON DELETE CASCADE,
);


CREATE TABLE RetailCenter
(
    BranchNumber int        PRIMARY KEY,
    Address      char(100)  NOT NULL
);

CREATE TABLE SortingCenter
(
    BranchNumber int PRIMARY KEY,
    Address      char(100)
);

CREATE TABLE PostmanPostwoman
(
    StaffID                 int,
    PhoneNumber             char(20) UNIQUE,
    PRIMARY KEY (StaffID),
    FOREIGN KEY (StaffID) REFERENCES Staff (StaffID) ON DELETE CASCADE
);

CREATE TABLE Insurance
(
    TrackingID        int PRIMARY KEY,
    Amount            int,
    SenderPhoneNumber char(20),
    FOREIGN KEY (SenderPhoneNumber) REFERENCES Sender (PhoneNumber) ON DELETE SET DEFAULT
);

CREATE TABLE Courier (
    StaffID			int		PRIMARY KEY
);

CREATE TABLE Offer
(
    BranchNumber int,
    TrackingID   int,
    PRIMARY KEY (BranchNumber, TrackingID),
    FOREIGN KEY (BranchNumber) REFERENCES SortingCenter ON DELETE CASCADE,
    FOREIGN KEY (TrackingID) REFERENCES Insurance ON DELETE CASCADE
);

CREATE TABLE Assign
(
    BranchNumber int,
    StaffID      int,
    TrackingID   int NOT NULL,
    PRIMARY KEY (BranchNumber, StaffID),
    FOREIGN KEY (StaffID) REFERENCES PostmanPostwoman ON DELETE CASCADE,
    FOREIGN KEY (BranchNumber) REFERENCES SortingNumber ON DELETE CASCADE
);

CREATE TABLE Schedule
(
    BranchNumber int,
    TrackingID   int,
    PRIMARY KEY (BranchNumber, TrackingID),
    FOREIGN KEY (TrackingID) REFERENCES ShippingOrder ON DELETE CASCADE,
    FOREIGN KEY (BranchNumber) REFERENCES RetailCenter ON DELETE CASCADE
);

CREATE TABLE Transportation
(
    TrackingID   int,
    BranchNumber int,
    StaffID      int,
    PRIMARY KEY (TrackingID, BranchNumber, StaffID),
    FOREIGN KEY (StaffID) REFERENCES Courier ON DELETE CASCADE,
    FOREIGN KEY (BranchNumber) REFERENCES SortingCenter ON DELETE CASCADE,
    FOREIGN KEY (TrackingID) REFERENCES ShippingOrder ON DELETE CASCADE
);

CREATE TABLE ReceivedBy
(
    BranchNumber int,
    ReceiveTime  char(50),
    PhoneNumber  char(20),
    PRIMARY KEY (PhoneNumber, ReceiveTime, PhoneNumber),
    FOREIGN KEY (PhoneNumber) REFERENCES Parcel (SenderPhoneNumber) ON DELETE SET DEFAULT,
    FOREIGN KEY (ReceiveTime) REFERENCES Parcel (ReceivedTime) ON DELETE SET DEFAULT,
    FOREIGN KEY (BranchNumber) REFERENCES RetailCenter ON DELETE SET DEFAULT
);




INSERT INTO Customer VALUES ('7783211111', 'Eddie', 'eddie0912', 'rao912912');
INSERT INTO Customer VALUES ('7783212222', 'FAN',  'realfanwu', 'realFan111');
INSERT INTO Customer VALUES ('7783213333', 'Doris', 'DorisXXX', 'DX3333');
INSERT INTO Customer VALUES ('7783214444', 'Yonas', 'Yoyo', 'YOYO123');
INSERT INTO Customer VALUES ('7783215555', 'Alex', 'Alexaaaa', 'AlexIsGOOOd');

INSERT INTO Staff VALUES (100);
INSERT INTO Staff VALUES (101);
INSERT INTO Staff VALUES (102);
INSERT INTO Staff VALUES (103);
INSERT INTO Staff VALUES (104);
INSERT INTO Staff VALUES (105);
INSERT INTO Staff VALUES (106);
INSERT INTO Staff VALUES (107);
INSERT INTO Staff VALUES (108);
INSERT INTO Staff VALUES (109);


INSERT INTO Parcel VALUES ('7783211111', '2021/03/02 14:37');
INSERT INTO Parcel VALUES ('7783212222', '2021/03/01 14:37');
INSERT INTO Parcel VALUES ('7783213333', '2021/02/28 15:37');
INSERT INTO Parcel VALUES ('7783214444','2021/02/27 12:32');
INSERT INTO Parcel VALUES ('7783215555','2021/02/26 17:37');




INSERT INTO Sender VALUES ('7783211111', 'Eddie', 'No.3 road, Mars');
INSERT INTO Sender VALUES ('7783212222', 'FAN', 'No.4 road, Mars');
INSERT INTO Sender VALUES ('7783213333', 'Doris', 'No.5 road, Mars');
INSERT INTO Sender VALUES ('7783214444', 'Yonas', 'No.6 road, Mars');
INSERT INTO Sender VALUES ('7783215555', 'Alex', 'No.7 road, Mars');


INSERT INTO Receiver VALUES ('7783211111', 'Eddie', 'No.3 road, Mars');
INSERT INTO Receiver VALUES ('7783212222', 'FAN', 'No.4 road, Mars');
INSERT INTO Receiver VALUES ('7783213333', 'Doris', 'No.5 road, Mars');
INSERT INTO Receiver VALUES ('7783214444'', 'Yonas'', 'No.6 road, Mars');
INSERT INTO Receiver VALUES ('7783215555', 'Alex', 'No.7 road, Mars');


INSERT INTO RetailCenter VALUES (8001, '118 No.3 Rd, Richmod, BC');
INSERT INTO RetailCenter VALUES (8002, '107 4th street, Vancouver, BC');
INSERT INTO RetailCenter VALUES (8003, '888 Ontario Street, Vancouver, BC');
INSERT INTO RetailCenter VALUES (8004, '222 Westbrook Mall, Vancouver, BC');
INSERT INTO RetailCenter VALUES (8005, '333 Wood street, New Westminster, BC');

INSERT INTO ShippingOrder VALUES(1000000001, 'normal', '2021/03/02', 0.5, '2x10x6', 'flight');
INSERT INTO ShippingOrder VALUES(1000000002, 'electronic',  '2021/03/01',0.2, '5x12x8', 'flight');
INSERT INTO ShippingOrder VALUES(1000000003, 'normal', '2021/02/28', 0.3, '4x15x2', 'flight');
INSERT INTO ShippingOrder VALUES(1000000004, 'normal', '2021/02/27', 0.9, '5x11x8', 'flight');
INSERT INTO ShippingOrder VALUES(1000000005, 'liquid', '2021/02/26', 0.4,'12x10x10', 'flight');

INSERT INTO Courier VALUES (105);
INSERT INTO Courier VALUES (106);
INSERT INTO Courier VALUES (107);
INSERT INTO Courier VALUES (108);
INSERT INTO Courier VALUES (109);

INSERT INTO PostmanPostwoman VALUES (100, '778012345');
INSERT INTO PostmanPostwoman VALUES (101, '778012346');
INSERT INTO PostmanPostwoman VALUES (102, '778012347');
INSERT INTO PostmanPostwoman VALUES (103, '77801234');
INSERT INTO PostmanPostwoman VALUES (104, '778012349');


INSERT INTO Insurance VALUES (12035478, 20, '7783211111');
INSERT INTO Insurance VALUES (12032234, 100, '7783212222');
INSERT INTO Insurance VALUES (12034578, 50, '7783213333');
INSERT INTO Insurance VALUES (12036678, 10, '7783214444');
INSERT INTO Insurance VALUES (12031000, 40, '7783215555');

INSERT INTO SortingCenter VALUES (7005, '123 Carter street, New Westminster, BC');
INSERT INTO SortingCenter VALUES (7004, '100 Nelson street, New Westminster, BC');
INSERT INTO SortingCenter VALUES (7003, '88 8th Ave, Vancouver, BC');
INSERT INTO SortingCenter VALUES (7002, '120 16th Ave, Vancouver, BC');
INSERT INTO SortingCenter VALUES (7001, '128 Water street, Vancouver, BC');

INSERT INTO Offer VALUES(8001, 1000000001);
INSERT INTO Offer VALUES(8002, 1000000002);
INSERT INTO Offer VALUES(8003, 1000000003);
INSERT INTO Offer VALUES(8004, 1000000004);
INSERT INTO Offer VALUES(8005, 1000000005);

INSERT INTO Assign VALUES(7001, 1000000001, 100);
INSERT INTO Assign VALUES(7002, 1000000002, 101);
INSERT INTO Assign VALUES(7003, 1000000003, 102);
INSERT INTO Assign VALUES(7004, 1000000004, 103);
INSERT INTO Assign VALUES(7005, 1000000005, 104);


INSERT INTO ReceivedBy VALUES(8001,  '2021/03/02', '7783211111');
INSERT INTO ReceivedBy VALUES(8002, '2021/03/01', '7783212222');
INSERT INTO ReceivedBy VALUES(8003, '2021/02/28', '7783213333');
INSERT INTO ReceivedBy VALUES(8004,  '2021/02/27', '7783214444');
INSERT INTO ReceivedBy VALUES(8001, '2021/02/26', '7783215555');

INSERT INTO Schedule VALUES(8001,1000000001);
INSERT INTO Schedule VALUES(8002,1000000002);
INSERT INTO Schedule VALUES(8003,1000000003);
INSERT INTO Schedule VALUES(8004,1000000004);
INSERT INTO Schedule VALUES(8005,1000000005);

INSERT INTO Transportation VALUES(1000000001, 7005, 105);
INSERT INTO Transportation VALUES(1000000002, 7004, 106);
INSERT INTO Transportation VALUES(1000000003, 7003, 107);
INSERT INTO Transportation VALUES(1000000004, 7002, 108);
INSERT INTO Transportation VALUES(1000000005, 7001, 109);

commit work;






