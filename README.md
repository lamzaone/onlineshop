# onlineshop
v0.9
My first GUI application, done in JAVA using Swing / MYSql.
Shop application for automotive parts with cart,checkout,order history/status, support messages, etc

The general structure of this code is really bad and I don't think I will ever refactor it, or improve anything on this.

Four types of users:
- Guest
  - Can view the items
- User
  - Can add to cart
  - Can place an order
  - Can edit cart
  - Can view order history and status
  - Can use promocodes for discount
  - Can send messages to staff
  - + Everything users above can do
- Employee
  - Can add/edit/remove items to the store
  - Can reply to user messages
  - Can manage orders
  - + Everything users above can do
- Admin
  - Can edit user roles
  - Can remove users
  - Can create promocodes of any % value
  - + Everything users above can do
