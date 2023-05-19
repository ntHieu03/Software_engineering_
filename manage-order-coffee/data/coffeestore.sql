-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 08, 2022 at 04:57 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeestore`
--

-- --------------------------------------------------------

--
-- Table structure for table `ct_hoadon`
--

CREATE TABLE `ct_hoadon` (
  `id` int(11) NOT NULL,
  `id_HD` int(10) UNSIGNED NOT NULL,
  `id_SP` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct_hoadon`
--

INSERT INTO `ct_hoadon` (`id`, `id_HD`, `id_SP`, `name`, `amount`, `price`) VALUES
(1, 2, 8, 'Latte', 2, 50000),
(2, 2, 4, 'Chocolate Đá Xay', 3, 55000),
(3, 3, 13, '', 5, 80000),
(4, 4, 13, '', 2, 100000),
(5, 4, 5, '', 5, 50000),
(6, 4, 7, '', 1, 50000),
(7, 5, 7, '', 1, 50000),
(8, 5, 2, '', 2, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `id_duty` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  `image_hover` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`id_duty`, `name`, `image`, `image_hover`) VALUES
(1, 'Bán hàng', 'Shop_20px.png', 'Shop_20px_active.png'),
(2, 'Quản lý Sản Phẩm', 'QLSP_20px.png', 'QLSP_20px_active.png'),
(3, 'Quản lý nhân viên', 'NhanVien_20px.png', 'NhanVien_20px_active.png'),
(4, 'Quản lý Khách Hàng', 'KhachHang_20px.png', 'KhachHang_20px_active.png'),
(5, 'Nhập & Xuất', 'ThongKe_20px.png', 'ThongKe_20px_active.png'),
(6, 'Nhà cung cấp', 'CongCu_20px.png', 'CongCu_20px_active.png'),
(7, 'Tài Khoản', 'CaiDat_20px.png', 'CaiDat_20px_active.png'),
(8, 'Thống kê', 'ThongKe_20px.png', 'ThongKe_20px_active.png');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_KH` int(10) UNSIGNED NOT NULL,
  `id_NV` int(10) UNSIGNED NOT NULL,
  `total_money` float DEFAULT NULL,
  `create_day` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`id`, `id_KH`, `id_NV`, `total_money`, `create_day`) VALUES
(1, 1, 1, 260000, '2021-10-30 07:20:02'),
(2, 1, 1, 324000, '2021-10-29 11:22:06'),
(3, 5, 1, 400000, '2022-11-08 03:51:22'),
(4, 3, 1, 550000, '2022-11-08 03:51:39'),
(5, 6, 1, 250000, '2022-11-12 03:52:06');

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `id_KH` int(10) UNSIGNED NOT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`id_KH`, `first_name`, `last_name`, `phone`, `email`, `address`) VALUES
(1, 'Quá', 'Dương', '0124352565', 'cutmetayroi@gmail.com', '12/234 Hung Vuong, Q5, HCM, VN'),
(2, 'Như', 'Võ', '0893757393', 'ngaymaihay@gmail.com', '124 Le Minh Xuan, Binh Chanh, HCM, VN'),
(3, 'Long', 'Cô', '08577568343', 'hocgioijava@gmail.com', '275 An Duong Vuong, Q5, HCM, VN'),
(4, 'Tiễn', 'Dương', '0868358383', 'nguyenvanC99@gmail.com', '121 Tran Hung Dao, Q1, HCM, VN'),
(5, 'Tào', 'Tháo', '0249289385', 'anhnhoem256i@gmail.com', '456 Duong Bo , Binh Thanh, HCM, VN'),
(6, 'Thanh Thiên', 'Thiên', '0586538533', 'myheart2598@gmail.com', '15 Ly Tu Trong, Q1, HCM, VN'),
(7, 'Phú Cháu Cô', 'Lan', '09021212121', 'phumecongso8@gmail.com', '1114 Đ. Nam Kỳ Khởi Nghĩa');

-- --------------------------------------------------------

--
-- Table structure for table `loai`
--

CREATE TABLE `loai` (
  `id_Loai` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loai`
--

INSERT INTO `loai` (`id_Loai`, `name`) VALUES
(1, 'Bánh Mặn'),
(2, 'Bánh Ngọt'),
(3, 'Cà Phê Pha Máy'),
(4, 'Cà Phê Truyền Thống'),
(5, 'Đá Xay'),
(6, 'Trà Trái Cây'),
(7, 'Trà Tươi');

-- --------------------------------------------------------

--
-- Table structure for table `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `id_NL` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nguyenlieu`
--

INSERT INTO `nguyenlieu` (`id_NL`, `name`, `amount`, `price`) VALUES
(1, 'Cafe Nguyên Chất', 41, 50000),
(2, 'Cafe Rang ', 64, 55000),
(3, 'Sữa Tươi Nguyên Kem', 12, 120000);

-- --------------------------------------------------------

--
-- Table structure for table `nguyenlieudadung`
--

CREATE TABLE `nguyenlieudadung` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_NL` int(10) UNSIGNED NOT NULL,
  `id_SP` int(10) UNSIGNED NOT NULL,
  `amount_material` int(10) UNSIGNED DEFAULT NULL,
  `amount_product` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id_SP` int(10) UNSIGNED NOT NULL,
  `id_Loai` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `amount` int(10) UNSIGNED DEFAULT NULL,
  `price` float DEFAULT NULL,
  `img` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id_SP`, `id_Loai`, `name`, `description`, `amount`, `price`, `img`) VALUES
(1, 1, 'Coffee vị bánh trắng', 'Bánh mì tươi kết hợp với chà bông và phô mai', 25, 30000, 'bky-001.jpg'),
(2, 1, 'Bánh Bông Lan Trứng Muối', 'Bánh mềm xốp kết hợp trứng muối thơm ngon', 25, 30000, 'bky-002.jpg'),
(3, 1, 'Bánh Mì Chả Lụa Xá Xíu', 'Bánh mì giòn thơm với chả lụa và thịt xá xíu thơm ngon, kết hợp cùng rau và gia vị, hòa quyện cùng n', 25, 20000, 'bky-003.jpg'),
(4, 2, 'Mousse Canh Dây', 'Một sự kết hợp khéo léo giữa kem và lớp bánh mềm, được phủ lên trên xốt chanh dây ngon tuyệt.', 25, 29000, 'cak-001.jpg'),
(5, 2, 'Mousse Red Vervet', 'Một sự kết hợp khéo léo giữa kem và lớp bánh mềm, với màu sắc đẹp mắt', 25, 29000, 'cak-002.jpg'),
(6, 2, 'Bánh Phô Mai Trà Xanh', 'Một sự sáng tạo mới mẻ, kết hợp giữa trà xanh đậm đà và phô mai ít béo.', 25, 29000, 'cak-003.jpg'),
(7, 3, 'Cappuccino', 'Bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa', 25, 50000, 'mcf-001.jpg'),
(8, 3, 'Latte', 'Bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa', 25, 50000, 'mcf-002.jpg'),
(9, 3, 'Caramel Macchiato', 'Bắt đầu từ dòng sữa tươi và lớp bọt sữa, sau đó hòa quyện cùng cà phê espresso đậm đà và sốt caramel', 25, 59000, 'mcf-003.jpg'),
(10, 4, 'Cà Phê Đen Đá', 'Cà phê đậm đà pha hoàn toàn từ Phin, cho thêm 1 thìa đường, một ít đá viên mát lạnh', 25, 29000, 'tcf-001.jpg'),
(11, 4, 'Cà Phê Sữa Đá', 'Cà phê được pha từ phin truyền thống, hòa cùng sữa đặc và thêm chút đá', 25, 29000, 'tcf-002.jpg'),
(12, 4, 'Cà Phê Đen Nóng', 'Cà phê đậm đà pha từ Phin', 25, 29000, 'tcf-003.jpg'),
(13, 5, 'Chocolate Đá Xay', 'Chocolate sữa đá xay kết hợp kem tươi mát lạnh', 25, 55000, 'frz-001.jpg'),
(14, 5, 'Matcha Đá Xanh', 'Matcha sữa đá xay kết hợp kem tươi mát lạnh', 25, 55000, 'frz-002.jpg'),
(15, 5, 'Cà phê Dừa Đá Xay và Thạch', 'Cà phê kết hợp với dừa tươi xay đậm đà thơm béo cùng thạch dai giòn', 25, 55000, 'frz-003.jpg'),
(16, 6, 'Trà Đào', 'Mùi vị chua ngọt thanh mát kết hợp đào miếng ngon tuyệt', 25, 50000, 'frt-001.jpg'),
(17, 6, 'Trà Cocktail', 'Vị trà thanh mát kết hợp với các loại trái cây tươi', 25, 50000, 'frt-002.jpg'),
(18, 6, 'Trà Vải - Lài', 'Trà lài thanh nhẹ kết hợp cùng vải tươi', 25, 50000, 'frt-003-4.jpg'),
(19, 7, 'Trà Lài', 'Trà lài hương vị truyền thống', 25, 35000, 'tea-001-2-3-4.jpg'),
(20, 7, 'Trà Xanh', 'Trà xanh hương vị truyền thống', 25, 35000, 'tea-001-2-3-4.jpg'),
(21, 7, 'Trà Ô Long', 'Trà ô long thơm ngon tuyệt hảo', 25, 35000, 'tea-001-2-3-4.jpg'),
(28, 1, 'Trà Bóng Siêu Cười', 'Đá vào Lời Ra', 10, 90000, 'Dapda.img'),
(29, 1, 'Bánh Phê Pha', 'Ăn Vào Phê 1 Tháng', 10, 500000, 'ME5Fu3FY.jpg'),
(30, 4, 'Cà Phê Vị Bánh Trắng', 'Phê PhanCung Em Đêm Nay', 10, 9000000, 'sNVVjAkl.jpg'),
(31, 1, 'Còng Số 8 Siết Tay Em', 'Cho Anh Bay Cùng Em Đêm Nay', 10, 88888, 'UFd8rL3p.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_HD` (`id_HD`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`id_duty`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_KH` (`id_KH`),
  ADD KEY `id_NV` (`id_NV`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id_KH`);

--
-- Indexes for table `loai`
--
ALTER TABLE `loai`
  ADD PRIMARY KEY (`id_Loai`);

--
-- Indexes for table `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`id_NL`);

--
-- Indexes for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_NL` (`id_NL`),
  ADD KEY `id_SP` (`id_SP`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id_SP`),
  ADD KEY `id_Loai` (`id_Loai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `id_duty` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id_KH` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `loai`
--
ALTER TABLE `loai`
  MODIFY `id_Loai` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `id_NL` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id_SP` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_hoadon`
--
ALTER TABLE `ct_hoadon`
  ADD CONSTRAINT `ct_hoadon_ibfk_1` FOREIGN KEY (`id_HD`) REFERENCES `hoadon` (`id`),
  ADD CONSTRAINT `ct_hoadon_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`id_KH`) REFERENCES `khachhang` (`id_KH`);

--
-- Constraints for table `nguyenlieudadung`
--
ALTER TABLE `nguyenlieudadung`
  ADD CONSTRAINT `nguyenlieudadung_ibfk_1` FOREIGN KEY (`id_NL`) REFERENCES `nguyenlieu` (`id_NL`),
  ADD CONSTRAINT `nguyenlieudadung_ibfk_2` FOREIGN KEY (`id_SP`) REFERENCES `sanpham` (`id_SP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
