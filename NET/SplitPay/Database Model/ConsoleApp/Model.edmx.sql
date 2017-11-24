
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 11/16/2017 21:29:59
-- Generated from EDMX file: E:\Dropbox\Repositories\SplitPay\NET\SplitPay\ConsoleApp\Model.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [SQLServerDB];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_UserBalance]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[BalanceSet] DROP CONSTRAINT [FK_UserBalance];
GO
IF OBJECT_ID(N'[dbo].[FK_UserTransaction]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[TransactionSet] DROP CONSTRAINT [FK_UserTransaction];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[UserSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[UserSet];
GO
IF OBJECT_ID(N'[dbo].[BalanceSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[BalanceSet];
GO
IF OBJECT_ID(N'[dbo].[TransactionSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[TransactionSet];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'UserSet'
CREATE TABLE [dbo].[UserSet] (
    [id] int IDENTITY(1,1) NOT NULL,
    [name] nvarchar(max)  NOT NULL,
    [email] nvarchar(max)  NOT NULL,
    [password] nvarchar(max)  NOT NULL,
    [documentNumber] nvarchar(100)  NOT NULL,
    [documentType] nvarchar(100)  NOT NULL
);
GO

-- Creating table 'BalanceSet'
CREATE TABLE [dbo].[BalanceSet] (
    [id] int IDENTITY(1,1) NOT NULL,
    [currentValue] int  NOT NULL,
    [group] int  NOT NULL,
    [User_documentNumber] nvarchar(100)  NOT NULL,
    [User_documentType] nvarchar(100)  NOT NULL
);
GO

-- Creating table 'TransactionSet'
CREATE TABLE [dbo].[TransactionSet] (
    [id] int IDENTITY(1,1) NOT NULL,
    [date] nvarchar(max)  NOT NULL,
    [value] int  NOT NULL,
    [description] nvarchar(max)  NOT NULL,
    [title] nvarchar(max)  NOT NULL,
    [User_documentNumber] nvarchar(100)  NOT NULL,
    [User_documentType] nvarchar(100)  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [documentNumber], [documentType] in table 'UserSet'
ALTER TABLE [dbo].[UserSet]
ADD CONSTRAINT [PK_UserSet]
    PRIMARY KEY CLUSTERED ([documentNumber], [documentType] ASC);
GO

-- Creating primary key on [id] in table 'BalanceSet'
ALTER TABLE [dbo].[BalanceSet]
ADD CONSTRAINT [PK_BalanceSet]
    PRIMARY KEY CLUSTERED ([id] ASC);
GO

-- Creating primary key on [id] in table 'TransactionSet'
ALTER TABLE [dbo].[TransactionSet]
ADD CONSTRAINT [PK_TransactionSet]
    PRIMARY KEY CLUSTERED ([id] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [User_documentNumber], [User_documentType] in table 'BalanceSet'
ALTER TABLE [dbo].[BalanceSet]
ADD CONSTRAINT [FK_UserBalance]
    FOREIGN KEY ([User_documentNumber], [User_documentType])
    REFERENCES [dbo].[UserSet]
        ([documentNumber], [documentType])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_UserBalance'
CREATE INDEX [IX_FK_UserBalance]
ON [dbo].[BalanceSet]
    ([User_documentNumber], [User_documentType]);
GO

-- Creating foreign key on [User_documentNumber], [User_documentType] in table 'TransactionSet'
ALTER TABLE [dbo].[TransactionSet]
ADD CONSTRAINT [FK_UserTransaction]
    FOREIGN KEY ([User_documentNumber], [User_documentType])
    REFERENCES [dbo].[UserSet]
        ([documentNumber], [documentType])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_UserTransaction'
CREATE INDEX [IX_FK_UserTransaction]
ON [dbo].[TransactionSet]
    ([User_documentNumber], [User_documentType]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------