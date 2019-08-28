CREATE SCHEMA `firmaveritabani` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;


CREATE TABLE `firmaveritabani`.`musteri` (
  `musteriId` INT NOT NULL AUTO_INCREMENT,
  `musteriNo` INT NULL,
  `musteriAdi` VARCHAR(45) NULL,
  `musteriSoyadi` VARCHAR(45) NULL,
  PRIMARY KEY (`musteriId`));



INSERT INTO `firmaveritabani`.`musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('1000', 'Melek', 'Kocabey');
INSERT INTO `firmaveritabani`.`musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('2000', 'Omer', 'Metin');
INSERT INTO `firmaveritabani`.`musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('2005', 'Burak', 'Akyildiz');
INSERT INTO `firmaveritabani`.`musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('3000', 'Umut', 'Atmaca');
INSERT INTO `firmaveritabani`.`musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('3050', 'Mimar', 'Aslan');

UPDATE `firmaveritabani`.`musteri` SET `musteriAdi`='Murat' WHERE `musteriId`='5';

SELECT * FROM firmaveritabani.musteri;

