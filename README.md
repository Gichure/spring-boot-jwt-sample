## SpringBoot 3 + JWT + Spring Security 6 Example
### Requirements
Have installed the following;
-  JDK 11 or higher - Download link
-  Maven 3.8 or higher - Download link
-  MySQL running on Docker - Download's link
-  An HTTP client such as Postman, Insomnia, cURL, etc. for testing the endpoints
-  IDE e.g. Eclipse, IntelliJ, Netbeans etc

Create a Spring Boot project needs these dependencies:
-  The Spring Web: to build Web, including RESTful applications using Spring MVC. It uses Apache Tomcat as the default embedded container.
-  The Spring Security: Allows implementing authentication and access-based control.
-  The Spring Data JPA: Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
-  MySQL Driver for Java: The MySQL driver makes it possible to interact with a database from a Java application.
-  Lombok: to assist with code generation.

#### Configure the database connection
Open the application configuration file src/resources/application.properties and add the code below:

```java
server.port=8000

spring.datasource.url=jdbc:mysql://localhost:3307/samples_db?serverTimezone=&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false
```
Run the application with the command mvn spring-boot:run; it will start at port 8000.

#### Add JSON Web Token dependencies
Open pom.xml and add the following under <dependencies> tags;  
```xml
		<dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.5</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
        </dependency>
```
1. jjwt-jackson - Integrates the Jackson library with JWT operations, optimizing how your Java application encodes and decodes JSON data within JWTs.
2. jjwt-api - Supplies the fundamental classes and interfaces for constructing and validating JWTs, providing the building blocks for JWT functionality in Java.
3. jjwt-impl - Provides the actual implementation for the interfaces from jjwt-api, enabling the generation, parsing, and management of JWTs according to your application's security protocols.  
#### Create Model Classes (Student and User)
Student.java

```java
package com.pgichure.samples.springbootjwt.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
    private Long studentId;
	@Column(name ="name", nullable = false)
    private String name;	
	@Column(name ="email", nullable = false)
    private String email;	
	@Column(name ="course", nullable = false)
    private String course;

}
```

User.java

```java
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id")
    private Long userId;
	
	@Column(name ="name", nullable = false)
    private String name;
	
	@Column(name ="email", nullable = false)
    private String email;
	
	@Column(name ="username", nullable = false)
    private String username;
	
	@Column(name ="password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
```
#### Create Repositories

#### Create Services

#### Create Endpoints


