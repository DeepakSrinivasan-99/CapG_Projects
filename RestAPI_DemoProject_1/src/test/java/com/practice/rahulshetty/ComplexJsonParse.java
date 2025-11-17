package com.practice.rahulshetty;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js1= new JsonPath(payload.CoursePrice());
		
		//1. Print No of courses returned by API

		int count = js1.getInt("courses.size()");
		System.out.println(count);
		
		//2.Print Purchase Amount

		int purchaseAmount = js1.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		//3. Print Title of the first course
		
		String titleFirstCourse = js1.get("courses[0].title");
		System.out.println(titleFirstCourse);

		
		//4. Print All course titles and their respective Prices
		
		for(int i=0;i<count;i++) {
			String title=js1.get("courses["+i+"].title");
			
			//int price =js1.getInt("courses["+i+"].price");
			//System.out.println(price);
			
			System.out.println("Title :"+title);
			System.out.println("Price: "+js1.getInt("courses["+i+"].price"));
			
		}
		
		//5. Print no of copies sold by RPA Course

		System.out.println("Print No: of copies sold by RPA course");
		
		for(int i=0;i<count;i++)
		{
			String courseTitles = js1.get("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{  
				//int price = js1.getInt("courses["+i+"].price");
				String price = js1.get("courses["+i+"].price").toString();
				System.out.println(price);
				break;
			}
		}

		
		
		

	}

}

















/*

{

"dashboard": {

"purchaseAmount": 910,

"website": "rahulshettyacademy.com"

},

"courses": [

{

"title": "Selenium Python",

"price": 50,

"copies": 6

},

{

"title": "Cypress",

"price": 40,

"copies": 4

},

{

"title": "RPA",

"price": 45,

"copies": 10

},
{

"title": "Cucumber",

"price": 10,

"copies": 15

}

]

}



1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount



*/