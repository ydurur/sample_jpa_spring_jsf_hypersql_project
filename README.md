# person
Bu proje localhost:5000/index.xhtml linknden ayağa kalmaktadır

Spring boot JSF,Primafaces ve HYPERSQL maven dependency'leri içerisinde barındırmaktadır.

İlk çalıştırılırken application.properties dosyasındaki spring.jpa.hibernate.ddl-auto=create satır sayesinde hibernate bizim için hypersqlde  javada ki person entity'sini tablo olarak yaratmaktadır ( in-memory database) bu satırı  spring.jpa.hibernate.ddl-auto=update olarak değiştirdikten sonra external olarak çalışacaktır.
