package com.levi9.practice;

import org.junit.Rule;
import org.junit.runner.RunWith;

import com.eclipsesource.restfuse.Assert;
import com.eclipsesource.restfuse.Destination;
import com.eclipsesource.restfuse.HttpJUnitRunner;
import com.eclipsesource.restfuse.MediaType;
import com.eclipsesource.restfuse.Method;
import com.eclipsesource.restfuse.Response;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;
import com.levi9.practice.model.Component;@

RunWith( HttpJUnitRunner.class )
public class ComponentRestTest {
	
	 @Rule
	  public Destination destination = new Destination( "http://localhost:8080" ); 

	 @Context
	  private Response response;
	
	 @HttpTest( method = Method.GET, path = "/api/component" ,type = MediaType.APPLICATION_JSON)
	public void testGet() {
		 Assert.assertOk( response );
	}
	 
	 @HttpTest( method = Method.GET, path = "/api/component/1" ,type = MediaType.APPLICATION_JSON)
	    public void testGetOne() {
	         Assert.assertOk( response );
	         
	    }

//	 @HttpTest( method = Method.DELETE, path = "/api/component/5" ,type = MediaType.APPLICATION_JSON)
//		public void testDelete() {
//			 Assert.assertOk( response );
//			 
//		}

	 @HttpTest( method = Method.POST, path = "/api/component/" ,type = MediaType.APPLICATION_JSON,
	         content ="{\"type\":\"SSD\", \"name\":\"Sandisk\",\"price\":4000, \"quantity\":0,\"itemCode\":\"i22\"}")
		public void testPost() {
			 Assert.assertCreated(response);
			 
		}
	
}
