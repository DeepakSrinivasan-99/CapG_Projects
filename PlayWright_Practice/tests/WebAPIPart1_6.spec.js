const {test, expect, request} = require('@playwright/test');
const {APiUtils} = require('../utils/APiUtils');
const loginPayLoad = {userEmail:"testergpd@gmail.com",userPassword:"Tester@123"};
const orderPayLoad = {orders:[{country:"India",productOrderedId:"68d177daf669d6cb0ae0fa33"}]};


let response;
test.beforeAll( async()=>
{
   
   process.env.NODE_TLS_REJECT_UNAUTHORIED = "0";

   const apiContext = await request.newContext({ignoreHTTPSErrors: true});
   const apiUtils = new APiUtils(apiContext,loginPayLoad);
   response =  await apiUtils.createOrder(orderPayLoad);

})


//create order is success
test('@API Place the order', async ({page})=>
{ 
    page.addInitScript(value => {

        window.localStorage.setItem('token',value);
      }, response.token );
await page.goto("https://rahulshettyacademy.com/client");
 await page.locator("button[routerlink*='myorders']").click();
 await page.locator("tbody").waitFor();
const rows = await page.locator("tbody tr");


for(let i =0; i<await rows.count(); ++i)
{
   const rowOrderId =await rows.nth(i).locator("th").textContent();
   console.log("rowOrder ID: "+rowOrderId);

   if (response.orderId.includes(rowOrderId))
   {
       await rows.nth(i).locator("button").first().click();
       break;
   }
}
const orderIdDetails =await page.locator(".col-text").textContent();
//await page.pause();
console.log("orderIdDetails :"+orderIdDetails);
expect(response.orderId.includes(orderIdDetails)).toBeTruthy();

await page.pause();

});

//Verify if order created is showing in history page
// Precondition - create order -