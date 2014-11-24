CREATE TABLE job (
     
     jobId int not null,
     jobName nvarchar(50) not null,     
     constraint PK_job PRIMARY KEY (jobId)
)

CREATE TABLE priority (
     
     priorityId int not null,
     priorityName nvarchar(50) not null,     
     constraint PK_priority PRIMARY KEY (priorityId)
)

CREATE TABLE province (
     
     provinceId int not null,
     provinceName nvarchar(50) not null,     
     constraint PK_province PRIMARY KEY (provinceId)
)

CREATE TABLE sex (
     
     sexId int not null,
     sexName nvarchar(50) not null,     
     constraint PK_sex PRIMARY KEY (sexId)
)

CREATE TABLE user_data (
     userId int not null,
     username nvarchar(50) not null,
     password nvarchar(50) not null,  
     sessionId nvarchar(50),
     birthdate date ,
     sexId int not null,
     jobId int not null,
     provinceId int not null,
     name nvarchar(50) not null,
     email nvarchar(50),
     
     constraint PK_user_data PRIMARY KEY (userId),
     constraint FK_type_job FOREIGN KEY (jobId) references job (jobId),
     constraint FK_type_province FOREIGN KEY (provinceId) references province (provinceId),
     constraint FK_type_sex FOREIGN KEY (sexId) references sex (sexId)
)


CREATE TABLE type_incomeoutlay (
     typeName nvarchar(50) not null,
     userId int not null,
     priorityId int not null,
     type nvarchar(20) not null     

     constraint PK_type_incomeoutlay PRIMARY KEY (typeName,userId),
     constraint FK_type_incomeoutlay_userId FOREIGN KEY (userId) references user_data (userId),
     constraint FK_type_incomeoutlay_priorityId FOREIGN KEY (priorityId) references priority (priorityId)
)

CREATE TABLE incomeoutlay (
     userId int not null,
     name nvarchar(50) not null,
     saveDate date not null,
     amount float not null,
     commentDetail nvarchar(256),
     typeName nvarchar(50) not null
          

     constraint PK_incomeoutlay PRIMARY KEY (userId,name,saveDate),
     constraint FK_incomeoutlay_userId FOREIGN KEY (userId) references user_data (userId),
	constraint FK_incomeoutlay_to_type FOREIGN KEY (typeName,userId) references type_incomeoutlay (typeName,userId)
)

