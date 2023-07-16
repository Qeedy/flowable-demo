//package com.flowabledemo.routers;
//
//
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ApprovalRouteBuilders extends RouteBuilder {
//
//	@Override
//	public void configure() throws Exception {
//		from("flowable:invoice-approval:receiver-approve").to("seda:receiver-approve");
//		
//		from("seda:receiver-approve")
//			.log("invoice approved")
//			.to("flowable:invoice-approval:receiver-approve-done");
//		
//		from("flowable:invoice-approval:receiver-reject")
//			.log("invoice rejected")
//			.to("flowable:invoice-approval:receiver-reject-done");
//		from("flowable:invoice-approval:division-approve")
//			.log("division approved")
//			.to("flowable:invoice-approval:division-approve-done");
//		from("flowable:invoice-approval:division-reject")
//			.log("division reject")
//			.to("flowable:invoice-approval:division-reject-done");
//		
//	}
//
//}
