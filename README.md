# Sample Project using Spring boot,JSf,Primafaces and HyperSQL

## This project is a sample crud functions using JPA and Hypernate.
This project works on **localhost:5000/index.xhtml**. You can change the port  on **application.properties** file.

On application.properties file you see the line **spring.jpa.hibernate.ddl-auto=create** (in-memory database) this line automatically creates the table on hypersql.Bu be ceraful on every start of the application it creates the table so you lost the data.to prevent this when you insert the first data you change the **spring.jpa.hibernate.ddl-auto=create** to this **spring.jpa.hibernate.ddl-auto=update** and then your data will not be lost.


