const base = require('@playwright/test');


exports.customtest = base.test.extend(
{
testDataForOrder :    {
    username : "testergpd@gmail.com",
    password : "Tester@123",
    productName:"ADIDAS ORIGINAL"
    
    }

}

)




