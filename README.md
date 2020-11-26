### **FCM Demo**

Postman Documentation:

Link : [https://fcm.googleapis.com/fcm/send](url)
Request Type : **POST** 
Headers : 

1. Authorization value: **key = <Server Key>**
2. Content-Type value : **application/json**

Body: 
`{
 "to" : "DEVICE_TOKEN",
 "collapse_key" : "type_a",
 "data" : {
     "title": "Title of Your Notification",
     "body": "Body of Your Notification"
 }
}`
