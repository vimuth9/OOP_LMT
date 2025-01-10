# Library Management Tool

# 01. Classes

## Book -----------------------

### Attributes

| Name        | Data Type | Access Modifier | Note                              |
|:------------|:---------:|:---------------:|:----------------------------------|
| bookID      |    int    |     private     |                                   |
| title       |  String   |     private     |                                   |
| author      |  String   |     private     |                                   |
| isAvailable |  boolean  |     private     |                                   |
| memberCount |    int    |     public      | Will get removed after adding sql | 

### Methods

| Name               | return Type | Access Modifier | Note |
|:-------------------|:-----------:|:---------------:|:-----|
| getId              |     int     |     public      |      |
| getTitle           |   String    |     public      |      |
| getAuthor          |   String    |     public      |      |
| isAvailable        |   boolean   |     public      |      |
| setAvailable       |    void     |     public      |      |
| displayBookDetails |   String    |     public      |      |

## Member -----------------------

### Attributes

| Name        | Data Type | Access Modifier | Note |
|:------------|:---------:|:---------------:|:-----|
| memberId    |    int    |     private     |      |
| name        |  String   |     private     |      |
| contact     |  String   |     private     |      |
| memberCount |    int    |     public      |      |

### Methods

| Name                 | return Type | Access Modifier | Note |
|:---------------------|:-----------:|:---------------:|:-----|
| getMemberId          |     int     |     public      |      |
| getName              |   String    |     public      |      |
| getContact           |   String    |     public      |      |
| displayMemberDetails |   String    |     public      |      |

## Staff -----------------------

### Attributes

| Name       | Data Type | Access Modifier | Note |
|:-----------|:---------:|:---------------:|:-----|
| staffId    |    int    |     private     |      |
| staffId    |  String   |     private     |      |
| password   |  String   |     private     |      |
| staffCount |    int    |     public      |      |

### Methods

| Name                | return Type | Access Modifier | Note |
|:--------------------|:-----------:|:---------------:|:-----|
| getStaffId          |     int     |     public      |      |
| getUsername         |   String    |     public      |      |
| verifyPassword      |   String    |     public      |      |
| displayStaffDetails |   String    |     public      |      |

# 02. Classes

## Library -----------------------

// need more attention

### Attributes

| Name        |           Data Type           | Access Modifier | Note |
|:------------|:-----------------------------:|:---------------:|:-----|
| books       |    Books array - ArrayList    |     private     |      |
| members     |   Members array - ArrayList   |     private     |      |
| staffList   |    Staff array - ArrayList    |     private     |      |
| transaction | Transaction array - ArrayList |     private     |      |

### Methods

| Name              |   return Type   | Access Modifier | Note |
|:------------------|:---------------:|:---------------:|:-----|
| getBooks          |     String      |     public      |      |
| getMembers        |     String      |     public      |      |
| getStaffList      |       int       |     public      |      |
| getTransactions   |     String      |     public      |      |
|                   |                 |                 |      |
| addBook           |      void       |     public      |      |
| addMember         |      void       |     public      |      |
| addStaff          |      void       |     public      |      |
|                   |                 |                 |      |
| getAvailableBooks | ArrayList<Book> |     public      |      |
| lendBook          |   Transaction   |     public      |      |
| findBookById      |      Book       |     public      |      |
| authenticate      |     boolean     |  public-static  |      |

## Transaction -----------------------

### Attributes

| Name             | Data Type | Access Modifier | Note                                               |
|:-----------------|:---------:|:---------------:|:---------------------------------------------------|
| transactionId    |    int    |     private     |                                                    |
| memberId         |    int    |     private     |                                                    |
| bookId           |    int    |     private     |                                                    |
| lendDate         | LocalDate |     private     |                                                    |
| transactionCount |    int    |  public-static  | Initially it is set to 0, change when sql is added |

### Methods

| Name                      |   return Type   | Access Modifier | Note                                 |
|:--------------------------|:---------------:|:---------------:|:-------------------------------------|
| getTransactionId          |       int       |     public      |                                      |
| getMemberId               |       int       |     public      |                                      |
| getBookId                 |       int       |     public      |                                      |
| getLendDate               |    LocalDate    |     public      |                                      |
| getReturnDate             |    LocalDate    |                 |                                      |
|                           |                 |                 |                                      |
|                           |                 |                 |                                      |
| calculateFine             |                 |                 | // Calculate fine (if returned late) |
| returnDate                |                 |                 | I don't know what it is stand for    |
| displayTransactionDetails |                 |                 |                                      |
