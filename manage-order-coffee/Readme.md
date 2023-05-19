# Project - Quản Lý Order Cửa Hàng Cà Phê

![](<https://download.logo.wine/logo/Java_(programming_language)/Java_(programming_language)-Logo.wine.png>)

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master) ![](https://img.shields.io/github/tag/pandao/editor.md.svg)

## Thành viên nhóm

| STT |   MSSV   | Họ và tên            |
| :-: | :------: | -------------------- |
|  1  | 21011124 | Ngô Trọng Hiếu       |
|  2  | 21011585 | Hoàng Ngọc Diệp      |
|  3  | 21010671 | Nguyễn Thành Đạt     |
|  4  | 21012086 | Lê Minh Quang        |

## Yêu Cầu:

- Xây dựng theo mô hình 3 layer + Hibernate ORM <br/>

## Database



## Thư Viện:

```
mysql-connector-java version 8.0.26
jcalendar-1.4
lombook
hiberbernate-core
hiberbernate-annotation
javassist
```

## Hướng dẫn cài đặt

Phần mềm chạy tốt trên nền tảng java version 18 với jdk version 18. với độ phân giải màn hình chuẩn của máy là > 1280x900 ( FullHD )


```
1. Tạo database "coffeestore" và import file data/coffeestore.sql vào phpadmin trên XAMPP .
```

```
2. Import tất cả các thư viện trong thư mục /libs/ nếu có .
```

```
3. Mở IDE  ưu tiên Intellij để import project .
```

```
4. Buil project sau đó run application để sử dụng được chương trình .

   Mỗi khi bạn thay đổi thủ công tệp pom.xml  bạn cần tải các thay đổi. IntelliJ IDEA thường sẽ hiển thị biểu tượng thông báo ở phần bên phải của trình chỉnh sửa đề xuất Tải 
   các thay đổi Maven được thực hiện cho dự án ( Ctrl+Shift+O).
````
#### Tài liệu hướng dẫn cấu hình với Intellij trong một số trường họp chưa load các libs tích hợp thêm
````
https://www.jetbrains.com/help/idea/delegate-build-and-run-actions-to-maven.html#auto_reload_maven
````

## Tổng quan giao diện của phần mềm

<h3 align="center">Giao diện chính</h3><br>


