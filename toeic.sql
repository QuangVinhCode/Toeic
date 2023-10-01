-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th10 01, 2023 lúc 02:25 PM
-- Phiên bản máy phục vụ: 8.0.31
-- Phiên bản PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `toeic`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baitap`
--

DROP TABLE IF EXISTS `baitap`;
CREATE TABLE IF NOT EXISTS `baitap` (
  `MaBT` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `CauHoi` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `GoiY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DapAn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DiemSo` int NOT NULL,
  `MaCD` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`MaBT`),
  KEY `MaCD` (`MaCD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `baitap`
--

INSERT INTO `baitap` (`MaBT`, `CauHoi`, `GoiY`, `DapAn`, `DiemSo`, `MaCD`) VALUES
('BT5023511', 'Sign', '', 'Ký', 10, '222');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chude`
--

DROP TABLE IF EXISTS `chude`;
CREATE TABLE IF NOT EXISTS `chude` (
  `MaCD` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `TenCD` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `HinhAnhCD` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`MaCD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chude`
--

INSERT INTO `chude` (`MaCD`, `TenCD`, `HinhAnhCD`) VALUES
('222', 'Marketing', 'Marketing.png'),
('321', 'Contract', 'Contract.png'),
('TK21312', 'Warranties', 'Warranties.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanhoi`
--

DROP TABLE IF EXISTS `phanhoi`;
CREATE TABLE IF NOT EXISTS `phanhoi` (
  `MaPH` int NOT NULL,
  `TieuDe` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `NoiDung` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MaTK` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`MaPH`),
  KEY `MaTK` (`MaTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `MaTK` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `TenTK` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MatKhauTK` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `QuyenHan` tinyint(1) NOT NULL,
  `HoTen` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `NamSinh` date NOT NULL,
  `GioiTinh` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `QueQuan` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`MaTK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaTK`, `TenTK`, `MatKhauTK`, `QuyenHan`, `HoTen`, `NamSinh`, `GioiTinh`, `QueQuan`, `Email`) VALUES
('TK2416969', 'l', 'l', 0, 'Lam Quốc Dân', '2001-01-11', 'Nam', 'Hồ Chí Minh', 'l@gmail.com'),
('TK4855540', 't', 't', 1, 'Ngô Duy Tấn', '2002-02-20', 'Nam', 'Bình Thuận', 'ngoduytan202@gmail.com'),
('TK5150003', 'a', 'a', 1, 'Lê Quang Vinh', '2002-03-21', 'Nam', 'Sóc Trăng', 'lequangvinh162@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoanthuchienchude`
--

DROP TABLE IF EXISTS `taikhoanthuchienchude`;
CREATE TABLE IF NOT EXISTS `taikhoanthuchienchude` (
  `MaTK` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MaCD` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `NgayTH` date NOT NULL,
  `HoanThanh` bit(1) NOT NULL,
  `TongDiem` int NOT NULL,
  PRIMARY KEY (`MaTK`,`MaCD`),
  KEY `MaCD` (`MaCD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoanthuchienchude`
--

INSERT INTO `taikhoanthuchienchude` (`MaTK`, `MaCD`, `NgayTH`, `HoanThanh`, `TongDiem`) VALUES
('TK5150003', '222', '2023-09-01', b'1', 0),
('TK5150003', '321', '2023-08-20', b'1', 20);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tuvung`
--

DROP TABLE IF EXISTS `tuvung`;
CREATE TABLE IF NOT EXISTS `tuvung` (
  `MaTV` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `TenTuVung` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DichTV` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `HinhAnhTV` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MaCD` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`MaTV`),
  KEY `MaCD` (`MaCD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tuvung`
--

INSERT INTO `tuvung` (`MaTV`, `TenTuVung`, `DichTV`, `HinhAnhTV`, `MaCD`) VALUES
('TV372911', 'Abide by', 'Tôn trọng', 'Abide by.png', '321'),
('TV372912', 'Sign', 'Ký', 'Sign.png', '321'),
('TV372918', 'Analyze', 'Phân tích', 'Analyze.png', '222'),
('TV609519', 'Assurance', 'Bảo đảm', 'Assurance.png', '321');

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baitap`
--
ALTER TABLE `baitap`
  ADD CONSTRAINT `baitap_ibfk_1` FOREIGN KEY (`MaCD`) REFERENCES `chude` (`MaCD`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Các ràng buộc cho bảng `phanhoi`
--
ALTER TABLE `phanhoi`
  ADD CONSTRAINT `phanhoi_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `taikhoan` (`MaTK`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Các ràng buộc cho bảng `taikhoanthuchienchude`
--
ALTER TABLE `taikhoanthuchienchude`
  ADD CONSTRAINT `taikhoanthuchienchude_ibfk_1` FOREIGN KEY (`MaTK`) REFERENCES `taikhoan` (`MaTK`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `taikhoanthuchienchude_ibfk_2` FOREIGN KEY (`MaCD`) REFERENCES `chude` (`MaCD`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Các ràng buộc cho bảng `tuvung`
--
ALTER TABLE `tuvung`
  ADD CONSTRAINT `tuvung_ibfk_1` FOREIGN KEY (`MaCD`) REFERENCES `chude` (`MaCD`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
