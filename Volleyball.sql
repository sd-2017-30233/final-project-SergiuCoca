CREATE DATABASE  IF NOT EXISTS `Volleyball`;
USE `Volleyball`;

CREATE TABLE IF NOT EXISTS `Volleyball`.`Coach`(
  `idCoach` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Nationality` varchar(30) DEFAULT NULL,
  `Birthdate` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idCoach`));
  
CREATE TABLE IF NOT EXISTS `Volleyball`.`Team`(
  `idTeam` int(10) NOT NULL AUTO_INCREMENT,
  `CoachFK` int(10) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Town` varchar(30) DEFAULT NULL,
  `Rank` int(10) DEFAULT NULL,
  PRIMARY KEY (`idTeam`),
  constraint team_fk FOREIGN KEY(`CoachFK`) REFERENCES Coach(`idCoach`)ON DELETE NO ACTION ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `Volleyball`.`Player`(
  `idPlayer` int(10) NOT NULL AUTO_INCREMENT,
  `TeamFK` int(10) DEFAULT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Birthdate` varchar(30) DEFAULT NULL,
  `Height` int(10) DEFAULT NULL,
  `Weight` int(10) DEFAULT NULL,
  `Spike` int(10) DEFAULT NULL,
  `Position` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idPlayer`),
  constraint player_fk FOREIGN KEY(`TeamFK`) REFERENCES Team(`idTeam`)ON DELETE NO ACTION ON UPDATE NO ACTION);
  
CREATE TABLE IF NOT EXISTS `Volleyball`.`Transfer`(
  `idTransfer` int(10) NOT NULL AUTO_INCREMENT,
  `playerTrans` int(10) DEFAULT NULL,
  `oldTeam` int(10) DEFAULT NULL,
  `newTeam` int(10) DEFAULT NULL,
  PRIMARY KEY (`idTransfer`),
  constraint trans_fk1 FOREIGN KEY(`playerTrans`) REFERENCES Player(`idPlayer`)ON DELETE NO ACTION ON UPDATE NO ACTION,
  constraint trans_fk2 FOREIGN KEY(`oldTeam`) REFERENCES Team(`idTeam`)ON DELETE NO ACTION ON UPDATE NO ACTION,
  constraint trans_fk3 FOREIGN KEY(`newTeam`) REFERENCES Team(`idTeam`)ON DELETE NO ACTION ON UPDATE NO ACTION);
  
CREATE TABLE IF NOT EXISTS `Volleyball`.`Matches`(
  `idMatch` int(10) NOT NULL AUTO_INCREMENT,
  `Team1` int(10) DEFAULT NULL,
  `Team2` int(10) DEFAULT NULL,
  `Data` varchar(30) DEFAULT NULL,
  `Score` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idMatch`),
  constraint match_fk1 FOREIGN KEY(`Team1`) REFERENCES Team(`idTeam`)ON DELETE NO ACTION ON UPDATE NO ACTION,
  constraint match_fk2 FOREIGN KEY(`Team2`) REFERENCES Team(`idTeam`)ON DELETE NO ACTION ON UPDATE NO ACTION);
  
CREATE TABLE IF NOT EXISTS `Volleyball`.`Users`(
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `rank` float(11) DEFAULT NULL,
  PRIMARY KEY (`userID`));
  
insert into Coach (idCoach, Name, Nationality, Birthdate) values (1, 'Jennica Halifax', 'Thailand', '05/05/1974');
insert into Coach (idCoach, Name, Nationality, Birthdate) values (2, 'Trefor Cassella', 'Philippines', '12/02/1977');
insert into Coach (idCoach, Name, Nationality, Birthdate) values (3, 'Zackariah Pepon', 'Indonesia', '20/09/1969');
insert into Coach (idCoach, Name, Nationality, Birthdate) values (4, 'Ash Addyman', 'Indonesia', '17/04/1965');
insert into Coach (idCoach, Name, Nationality, Birthdate) values (5, 'Corenda Sinnock', 'Denmark', '17/01/1966');

insert into Team (idTeam, CoachFK, Name, Town, Rank) values (1, 1, null, 'Hexi', 39);
insert into Team (idTeam, CoachFK, Name, Town, Rank) values (2, 2, null, 'Tangjia', 3);
insert into Team (idTeam, CoachFK, Name, Town, Rank) values (3, 2, null, 'Votuporanga', 8);
insert into Team (idTeam, CoachFK, Name, Town, Rank) values (4, 1, null, 'Alcáçovas', 40);
insert into Team (idTeam, CoachFK, Name, Town, Rank) values (5, 5, null, 'Cololaca', 71);
insert into Team (idTeam, CoachFK, Name, Town, Rank) values (0, 5, null, 'Cololaca', 71);

insert into Player (idPlayer, TeamFK, Name, Birthdate, Height, Weight, Spike, Position) values (1, 2, 'Zia', '26/10/1984', 195, 86, 329, null);
insert into Player (idPlayer, TeamFK, Name, Birthdate, Height, Weight, Spike, Position) values (2, 4, 'Saraann', '04/06/1987', 189, 96, 321, null);
insert into Player (idPlayer, TeamFK, Name, Birthdate, Height, Weight, Spike, Position) values (3, 1, 'Reinhard', '28/12/1991', 191, 94, 324, null);
insert into Player (idPlayer, TeamFK, Name, Birthdate, Height, Weight, Spike, Position) values (4, 5, 'Ashton', '08/02/1983', 185, 98, 347, null);
insert into Player (idPlayer, TeamFK, Name, Birthdate, Height, Weight, Spike, Position) values (5, 4, 'Teodoro', '20/01/1988', 194, 84, 336, null);

insert into Transfer (idTransfer, playerTrans, oldTeam, newTeam) values (1, 5, 5, 3);
insert into Transfer (idTransfer, playerTrans, oldTeam, newTeam) values (2, 2, 3, 5);
insert into Transfer (idTransfer, playerTrans, oldTeam, newTeam) values (3, 1, 2, 3);
insert into Transfer (idTransfer, playerTrans, oldTeam, newTeam) values (4, 3, 2, 4);
insert into Transfer (idTransfer, playerTrans, oldTeam, newTeam) values (5, 1, 2, 3);

insert into Matches (idMatch, Team1, Team2, Data, Score) values (1, 4, 4, '18/08/2017','3:0');
insert into Matches (idMatch, Team1, Team2, Data, Score) values (2, 3, 3, '26/08/2017', '1:3');
insert into Matches (idMatch, Team1, Team2, Data, Score) values (3, 4, 4, '13/06/2017', '2:3');
insert into Matches (idMatch, Team1, Team2, Data, Score) values (4, 4, 5, '14/09/2017', '3:1');
insert into Matches (idMatch, Team1, Team2, Data, Score) values (5, 1, 5, '30/07/2017', '0:3');

insert into Users (userID, username, password, rank) values (1, 'rpowland0', 'rBY6314JD3dG', 1);
insert into Users (userID, username, password, rank) values (2, 'mpoizer1', 's9CfQjw', 2);
insert into Users (userID, username, password, rank) values (3, 'ktrew2', 'UpkoOO', 0);
insert into Users (userID, username, password, rank) values (4, 'pfrisdick3', 'vH56VrvyKi', 1);
insert into Users (userID, username, password, rank) values (5, 'hlassetter4', '7v2jc9M0R', 2);