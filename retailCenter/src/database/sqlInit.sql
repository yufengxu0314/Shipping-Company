CREATE TABLE customer
(
    PhoneNumber char(20),
    Name       char(50)    NOT NULL,
    Address     char(100),
    PRIMARY KEY (PhoneNumber)
);

INSERT INTO customer (PhoneNumber,Name,Address) VALUES ('7783211111', 'Eddie', 'No.3 road, Mars');
INSERT INTO customer (PhoneNumber,Name,Address) VALUES ('7783212222', 'FAN', 'No.4 road, Mars');
INSERT INTO customer (PhoneNumber,Name,Address) VALUES ('7783213333', 'Doris', 'No.5 road, Mars');
INSERT INTO customer (PhoneNumber,Name,Address) VALUES ('7783214444', 'Yonas','No.6 road, Mars');
INSERT INTO customer (PhoneNumber,Name,Address) VALUES ('7783215555', 'Alex', 'No.7 road, Mars');


CREATE TABLE sender
(
    PhoneNumber char(20)  UNIQUE,
    Name        char(50),
    SenderAddress     char(100),
    PRIMARY KEY (Name, PhoneNumber)
);

INSERT INTO Sender (PhoneNumber,Name,SenderAddress) VALUES ('7783211111', 'Eddie', 'No.3 road, Mars');
INSERT INTO Sender (PhoneNumber,Name,SenderAddress) VALUES ('7783212222', 'FAN', 'No.4 road, Mars');
INSERT INTO Sender (PhoneNumber,Name,SenderAddress) VALUES ('7783213333', 'Doris', 'No.5 road, Mars');
INSERT INTO Sender (PhoneNumber,Name,SenderAddress) VALUES ('7783214444', 'Yonas', 'No.6 road, Mars');
INSERT INTO Sender (PhoneNumber,Name,SenderAddress) VALUES ('7783215555', 'Alex', 'No.7 road, Mars');

CREATE TABLE receiver
(
    PhoneNumber char(20)  UNIQUE,
    Name        char(50),
    ReceiverAddress     char(100),
    PRIMARY KEY (Name, PhoneNumber)
);

INSERT INTO receiver (PhoneNumber,Name,ReceiverAddress) VALUES ('7783211111', 'Eddie', 'No.3 road, Mars');
INSERT INTO receiver (PhoneNumber,Name,ReceiverAddress)  VALUES ('7783212222', 'FAN', 'No.4 road, Mars');
INSERT INTO receiver (PhoneNumber,Name,ReceiverAddress)  VALUES ('7783213333', 'Doris', 'No.5 road, Mars');
INSERT INTO receiver (PhoneNumber,Name,ReceiverAddress)  VALUES ('7783214444', 'Yonas', 'No.6 road, Mars');
INSERT INTO receiver (PhoneNumber,Name,ReceiverAddress)  VALUES ('7783215555', 'Alex', 'No.7 road, Mars');

CREATE TABLE shippingorder (
                               TrackingID	    int,
                               ContentType		    char(50)	NOT NULL,
                               OrderDate		    char(50)	NOT NULL,
                               Weight			    int,
                               PacelSize			    char(50),
                               ShippingMethod	    char(20),
                               Price             int,
                               Sender  char(20)           NOT NULL,
                               Receiver  char(20)           NOT NULL,
                               PRIMARY KEY (TrackingID),
                               FOREIGN KEY (Sender) REFERENCES sender (PhoneNumber),
                               FOREIGN KEY (Receiver) REFERENCES receiver (PhoneNumber)
);

INSERT INTO shippingorder (TrackingID, ContentType, OrderDate, Weight, PacelSize, ShippingMethod, Price, Sender, Receiver) VALUES(1000000001, 'normal', '2021/03/02', 0.5, '2x10x6', 'sea', 10, '7783211111','7783212222' );
INSERT INTO shippingorder (TrackingID, ContentType, OrderDate, Weight, PacelSize, ShippingMethod, Price, Sender, Receiver) VALUES(1000000002, 'electronic',  '2021/03/01',0.2, '5x12x8', 'air', 10,'7783211111','7783212222');
INSERT INTO shippingorder (TrackingID, ContentType, OrderDate, Weight, PacelSize, ShippingMethod, Price, Sender, Receiver) VALUES(1000000003, 'normal', '2021/02/28', 0.3, '4x15x2', 'land', 10, '7783211111','7783212222');
INSERT INTO shippingorder (TrackingID, ContentType, OrderDate, Weight, PacelSize, ShippingMethod, Price, Sender, Receiver) VALUES(1000000004, 'normal', '2021/02/27', 0.9, '5x11x8', 'sea', 10, '7783211111','7783212222');
INSERT INTO shippingorder (TrackingID, ContentType, OrderDate, Weight, PacelSize, ShippingMethod, Price, Sender, Receiver) VALUES(1000000005, 'liquid', '2021/02/26', 0.4,'12x10x10', 'air',10, '7783211111','7783212222');

CREATE TABLE retailcenter
(
    BranchNumber int PRIMARY KEY,
    Address      char(100) NOT NULL
);

CREATE TABLE sortingcenter
(
    BranchNumber int PRIMARY KEY,
    Address      char(100)
);

INSERT INTO retailcenter (BranchNumber, Address) VALUES (8001, '118 No.3 Rd, Richmod, BC');
INSERT INTO retailcenter (BranchNumber, Address) VALUES (8002, '107 4th street, Vancouver, BC');
INSERT INTO retailcenter (BranchNumber, Address) VALUES (8003, '888 Ontario Street, Vancouver, BC');
INSERT INTO retailcenter (BranchNumber, Address) VALUES (8004, '222 Westbrook Mall, Vancouver, BC');
INSERT INTO retailcenter (BranchNumber, Address) VALUES (8005, '333 Wood street, New Westminster, BC');


INSERT INTO sortingcenter (BranchNumber, Address) VALUES (7005, '123 Carter street, New Westminster, BC');
INSERT INTO sortingcenter (BranchNumber, Address) VALUES (7004, '100 Nelson street, New Westminster, BC');
INSERT INTO sortingcenter (BranchNumber, Address) VALUES (7003, '88 8th Ave, Vancouver, BC');
INSERT INTO sortingcenter (BranchNumber, Address) VALUES (7002, '120 16th Ave, Vancouver, BC');
INSERT INTO sortingcenter (BranchNumber, Address) VALUES (7001, '128 Water street, Vancouver, BC');

CREATE TABLE courier (
    StaffID			int		PRIMARY KEY
);

INSERT INTO courier (StaffID) VALUES (105);
INSERT INTO courier (StaffID) VALUES (106);
INSERT INTO courier (StaffID) VALUES (107);
INSERT INTO courier (StaffID) VALUES (108);
INSERT INTO courier (StaffID) VALUES (109);


CREATE TABLE staff (
                       StaffID			    int		PRIMARY KEY,
                       BranchNumber	    int,
                       FOREIGN KEY (BranchNumber) REFERENCES SortingCenter(BranchNumber)
);


INSERT INTO staff (StaffID, BranchNumber) VALUES (100, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (101, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (102, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (103, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (104, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (105, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (106, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (107, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (108, 7005);
INSERT INTO staff (StaffID, BranchNumber) VALUES (109, 7005);

CREATE TABLE postmanpostwoman
(
    StaffID                 int,
    PhoneNumber             char(20) UNIQUE,
    PRIMARY KEY (StaffID),
    FOREIGN KEY (StaffID) REFERENCES Staff (StaffID) ON DELETE CASCADE
);


INSERT INTO postmanpostwoman (StaffID, PhoneNumber) VALUES (100, '778012345');
INSERT INTO postmanpostwoman (StaffID, PhoneNumber) VALUES (101, '778012346');
INSERT INTO postmanpostwoman (StaffID, PhoneNumber) VALUES (102, '778012347');
INSERT INTO postmanpostwoman (StaffID, PhoneNumber) VALUES (103, '778012348');
INSERT INTO postmanpostwoman (StaffID, PhoneNumber) VALUES (104, '778012349');



CREATE TABLE parcel (
                        SenderPhoneNumber   char(20),
                        ReceivedTime        char(50),
                        SenderName			char(50),
                        PRIMARY KEY (SenderPhoneNumber, ReceivedTime)
);

INSERT INTO parcel (SenderPhoneNumber, ReceivedTime, SenderName) VALUES ('7783211111', '2021/03/02 14:37', 'Yonas');
INSERT INTO parcel (SenderPhoneNumber, ReceivedTime, SenderName)  VALUES ('7783212222', '2021/03/01 14:37', 'Yonas');
INSERT INTO parcel (SenderPhoneNumber, ReceivedTime, SenderName)  VALUES ('7783213333', '2021/02/28 15:37', 'Yonas');
INSERT INTO parcel (SenderPhoneNumber, ReceivedTime, SenderName)  VALUES ('7783214444','2021/02/27 12:32', 'Yonas');
INSERT INTO parcel (SenderPhoneNumber, ReceivedTime, SenderName)  VALUES ('7783215555','2021/02/26 17:37', 'Yonas');

CREATE TABLE insurance
(
    TrackingID        int PRIMARY KEY,
    Amount            int,
    SenderPhoneNumber char(20)
);
INSERT INTO insurance (TrackingID, Amount, SenderPhoneNumber) VALUES (12035478, 20, '7783211111');
INSERT INTO insurance (TrackingID, Amount, SenderPhoneNumber)  VALUES (12032234, 100, '7783212222');
INSERT INTO insurance (TrackingID, Amount, SenderPhoneNumber)  VALUES (12034578, 50, '7783213333');
INSERT INTO insurance (TrackingID, Amount, SenderPhoneNumber)  VALUES (12036678, 10, '7783214444');
INSERT INTO insurance (TrackingID, Amount, SenderPhoneNumber)  VALUES (12031000, 40, '7783215555');

CREATE TABLE offer
(
    BranchNumber int,
    TrackingID   int,
    PRIMARY KEY (BranchNumber, TrackingID)
);

INSERT INTO offer (BranchNumber, TrackingID) VALUES(8001, 1000000001);
INSERT INTO offer (BranchNumber, TrackingID)  VALUES(8002, 1000000002);
INSERT INTO offer (BranchNumber, TrackingID)  VALUES(8003, 1000000003);
INSERT INTO offer (BranchNumber, TrackingID)  VALUES(8004, 1000000004);
INSERT INTO offer (BranchNumber, TrackingID)  VALUES(8005, 1000000005);

CREATE TABLE assign
(
    BranchNumber int,
    StaffID      int,
    TrackingID   int NOT NULL,
    PRIMARY KEY (BranchNumber, StaffID)
);

INSERT INTO assign (BranchNumber, StaffID, TrackingID) VALUES(7001, 1000000001, 100);
INSERT INTO assign (BranchNumber, StaffID, TrackingID)  VALUES(7002, 1000000002, 101);
INSERT INTO assign (BranchNumber, StaffID, TrackingID)  VALUES(7003, 1000000003, 102);
INSERT INTO assign (BranchNumber, StaffID, TrackingID)  VALUES(7004, 1000000004, 103);
INSERT INTO assign (BranchNumber, StaffID, TrackingID)  VALUES(7005, 1000000005, 104);

CREATE TABLE schedule
(
    BranchNumber int,
    TrackingID   int,
    PRIMARY KEY (BranchNumber, TrackingID),
    FOREIGN KEY (TrackingID) REFERENCES ShippingOrder (TrackingID) ON DELETE CASCADE,
    FOREIGN KEY (BranchNumber) REFERENCES RetailCenter (BranchNumber) ON DELETE CASCADE
);

INSERT INTO schedule (BranchNumber, TrackingID) VALUES(8001,1000000001);
INSERT INTO schedule (BranchNumber, TrackingID)  VALUES(8002,1000000002);
INSERT INTO schedule (BranchNumber, TrackingID)  VALUES(8003,1000000003);
INSERT INTO schedule (BranchNumber, TrackingID)  VALUES(8004,1000000004);
INSERT INTO schedule (BranchNumber, TrackingID)  VALUES(8005,1000000005);

CREATE TABLE transportation
(
    TrackingID   int,
    BranchNumber int,
    StaffID      int,
    PRIMARY KEY (TrackingID, BranchNumber, StaffID),
    FOREIGN KEY (StaffID) REFERENCES Courier (StaffID) ON DELETE CASCADE,
    FOREIGN KEY (BranchNumber) REFERENCES SortingCenter (BranchNumber) ON DELETE CASCADE,
    FOREIGN KEY (TrackingID) REFERENCES ShippingOrder (TrackingID) ON DELETE CASCADE
);

INSERT INTO transportation (TrackingID, BranchNumber,StaffID) VALUES(1000000001, 7005, 105);
INSERT INTO transportation (TrackingID, BranchNumber,StaffID)  VALUES(1000000002, 7004, 106);
INSERT INTO transportation (TrackingID, BranchNumber,StaffID)  VALUES(1000000003, 7003, 107);
INSERT INTO transportation (TrackingID, BranchNumber,StaffID)  VALUES(1000000004, 7002, 108);
INSERT INTO transportation (TrackingID, BranchNumber,StaffID)  VALUES(1000000005, 7001, 109);

CREATE TABLE receivedby
(
    BranchNumber int,
    ReceiveTime  char(50),
    PhoneNumber  char(20),
    PRIMARY KEY (BranchNumber, ReceiveTime, PhoneNumber)
);

INSERT INTO receivedby (BranchNumber, ReceiveTime, PhoneNumber) VALUES(8001,  '2021/03/02', '7783211111');
INSERT INTO receivedby (BranchNumber, ReceiveTime, PhoneNumber)  VALUES(8002, '2021/03/01', '7783212222');
INSERT INTO receivedby (BranchNumber, ReceiveTime, PhoneNumber)  VALUES(8003, '2021/02/28', '7783213333');
INSERT INTO receivedby (BranchNumber, ReceiveTime, PhoneNumber)  VALUES(8004,  '2021/02/27', '7783214444');
INSERT INTO receivedby (BranchNumber, ReceiveTime, PhoneNumber)  VALUES(8001, '2021/02/26', '7783215555');
