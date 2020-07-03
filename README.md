# ServeByte Services 
Aiding service delivery during the pandemic

## API Set up
-> clone the repo: git clone github.com/dipperLyra/servebyte-service-deliveries.git
-> install the maven dependencies: mvn clean install
-> using postman or any other tool

## Endpoints
1. Return all delivery companies: GET /api/v1/delivery-company/ 

2. Return a specific delivery company: GET /api/v1/delivery-company/{id}

3. Create a delivery company: POST /api/v1/delivery-company/

   sample payload:
   ````
   {
        "companyName": "DHL",
        "logo": "https://i.ytimg.com/vi/1JDBc_BvCzY/maxresdefault.jpg", //from CDN
        "email": "dhl@delivery.com",
        "phoneNumber": "08052137845",
        "password": "123456",
        "channels": [{"name": "rail", "price":"210.00"}, {"name": "boat", "price":"210.00"}]        
    }
    ````
   
4. Return all restaurants: GET /api/v1/restaurant/

5. Return a specific restaurant: GET /api/v1/restaurant/{id}

6. Create a restaurant: POST /api/v1/restaurant/ 

   sample payload:
   ````
   {
    "restaurantName": "Ocean Basket",
    "logo": "https://i.ytimg.com/vi/1JDBc_BvCzY/maxresdefault.jpg",
    "email": "help@oceanbasket.com",
    "phoneNumber": "08052137845",
    "password": "123456",
    "city": [
        {"name":"UYO"}, {"name":"Enugu"}
        ],
    "meals": [
        {"name": "Calamari with potato", "price": "130.50", "preparationTime": "25", "description": "local delicacy from Enugu", "photo": "https://1.bp.blogspot.com/-K0ab-3O5wL4/WHr9mtDWDCI/AAAAAAAAAe0/LFTmDlveDF0RiOawL53aWRaiF0aot4ylgCLcB/s1600/getty-fd004686-black-beans-x.jpg"}, 
        {"name": "Prawns and Salmon fish", "price": "750.00", "preparationTime": "40", "description": "local delicacy from Igbo land", "photo": "https://igbophilia.files.wordpress.com/2014/03/d6862-20131016_141036.jpg?w=521&h=403"}
        ],
    "deliveryCompany": ["Gokada", "Max.ng"]
   }
   ````
