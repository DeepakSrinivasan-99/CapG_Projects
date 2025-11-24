class APiUtils
{

    constructor(apiContext,loginPayLoad)
    {
        this.apiContext =apiContext; 
        this.loginPayLoad = loginPayLoad;
        
    }

    async getToken()
     {
        const loginResponse =  await  this.apiContext.post("https://rahulshettyacademy.com/api/ecom/auth/login",
        {
            data:this.loginPayLoad,
            ignoreHTTPSErrors: true,
         } 
        ); //200,201,



        const loginResponseJson = await loginResponse.json();
        console.log("loginResponse JSON  using API: "+JSON.stringify(loginResponseJson));
        const token =loginResponseJson.token;
        console.log("Token : "+token);
        return token;

    }

    async createOrder(orderPayLoad)
    {
        let response = {};
       response.token = await this.getToken();
    const orderResponse = await this.apiContext
    .post("https://rahulshettyacademy.com/api/ecom/order/create-order",
   {
    data : orderPayLoad,
    headers:{
                'Authorization' :response.token,
                'Content-Type'  : 'application/json'
            },
     ignoreHTTPSErrors: true

   });

   const orderResponseJson =await orderResponse.json();
   console.log("Order API response: "+JSON.stringify(orderResponseJson));
  
   const orderId = orderResponseJson.orders? orderResponseJson.orders[0]: null;

      console.log("OrderID: "+orderId);

   response.orderId = orderId;

   return response;
}



    }
module.exports = {APiUtils};




