package com.appstore.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.appstore.interfaces.DataBase;

public class OperateService {
	
	  DataBase dbService=null;
      public String operate_software(HttpServletRequest request) throws SQLException{
    	 
    	  //int time = Integer.parseInt(request.getParameter("time"));
    	  int classify = Integer.parseInt(request.getParameter("classify"));
    	  String sql = "select * from software where soft_classify = "+classify  ;
    	  System.out.println(sql);
    	  dbService=new DataBaseService();
    	  ResultSet result = dbService.QueryDML(sql);
    	  StringBuilder json = new StringBuilder();
    	  json.append('[');
    	  json.append("{operate:\"software\"},");
    	  while(result.next()){
    		  json.append('{');
    		  json.append("id:").append(result.getInt("id")).append(",");
    		  json.append("soft_name:\"").append(result.getString("soft_name")).append("\",");
    		  json.append("dev_name:\"").append(result.getString("dev_name")).append("\",");
    		  json.append("dev_id:\"").append(result.getString("dev_id")).append("\",");
    		  json.append("update_time:\"").append(result.getString("update_time")).append("\",");
    		  json.append("soft_language:\"").append(result.getString("soft_language")).append("\",");
    		  json.append("soft_version:\"").append(result.getString("soft_version")).append("\",");
    		  json.append("soft_download_count:").append(result.getInt("soft_download_count")).append(",");
    		  json.append("introduce:\"").append(result.getString("introduce")).append("\",");
    		  json.append("soft_size:").append(result.getInt("soft_size"));
    		  json.append("},"); 			
    	  }
    	  json.deleteCharAt(json.length()-1);
    	  json.append(']');
    	  dbService.CloseAll();
    	  return json.toString();
      }
      
      public String operate_game(HttpServletRequest request){
    	
    	  try {
			//int time = Integer.parseInt(request.getParameter("time"));
			int classify = Integer.parseInt(request.getParameter("classify"));
			String sql = "select * from game where game_classify = " + classify;
			System.out.println(sql);
			 dbService=new DataBaseService();
	    	ResultSet result = dbService.QueryDML(sql);
			StringBuilder json = new StringBuilder();
	    	  json.append('[');
	    	  json.append("{operate:\"game\"},");
	    	  while(result.next()){
	    		  json.append('{');
	    		  json.append("id:").append(result.getInt("id")).append(",");
	    		  json.append("game_name:\"").append(result.getString("game_name")).append("\",");
	    		  json.append("dev_name:\"").append(result.getString("dev_name")).append("\",");
	    		  json.append("dev_id:\"").append(result.getString("dev_id")).append("\",");
	    		  json.append("update_time:\"").append(result.getString("update_time")).append("\",");
	    		  json.append("soft_language:\"").append(result.getString("soft_language")).append("\",");
	    		  json.append("soft_version:\"").append(result.getString("soft_version")).append("\",");
	    		  json.append("soft_download_count:").append(result.getInt("soft_download_count")).append(",");
	    		  json.append("introduce:\"").append(result.getString("introduce")).append("\",");
	    		  json.append("size:").append(result.getInt("size"));
	    		  json.append("},");
	    	  
	    	  }
	    	  json.deleteCharAt(json.length()-1);
	    	  json.append(']');
	    	dbService.CloseAll();
	    	  return json.toString();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	  return null;
      }

      
      public String operate_paihang(HttpServletRequest request){
    	  
    	  try{
    		    
    			String sql = "select * from software";
    			dbService=new DataBaseService(); 
      			ResultSet result = dbService.QueryDML(sql);
    			StringBuilder json = new StringBuilder();
    			 json.append("[{operate:\"paihang_software\"},");
    			for(int i = 0 ; i < 20 && result.next() ; i++){
    				  json.append('{');
    	    		  json.append("id:").append(result.getInt("id")).append(",");
    	    		  json.append("soft_name:\"").append(result.getString("soft_name")).append("\",");
    	    		  json.append("dev_name:\"").append(result.getString("dev_name")).append("\",");
    	    		  json.append("dev_id:\"").append(result.getString("dev_id")).append("\",");
    	    		  json.append("update_time:\"").append(result.getString("update_time")).append("\",");
    	    		  json.append("soft_language:\"").append(result.getString("soft_language")).append("\",");
    	    		  json.append("soft_version:\"").append(result.getString("soft_version")).append("\",");
    	    		  json.append("soft_download_count:").append(result.getString("soft_download_count")).append(",");
    	    		  json.append("introduce:\"").append(result.getString("introduce")).append("\",");
    	    		  json.append("soft_size:").append(result.getInt("soft_size"));
    	    		  json.append("},"); 				
    			}
    			
//		    		    sql = "select * from game Order by download_count desc";
//		    			result = stat.executeQuery(sql);
//    			
//    			      json.append("{operate:\"paihang_game\"},");
//    			      for(int i = 0 ; i < 20 && result.next() ; i++){
//    			    	  json.append('{');
//    		    		  json.append("id:").append(result.getInt(1)).append(",");
//    		    		  json.append("game_name:\"").append(result.getString(2)).append("\",");
//    		    		  json.append("dev_name:\"").append(get_devname(result.getString(3))).append("\",");
//    		    		  json.append("dev_id:\"").append(result.getString(3)).append("\",");
//    		    		  json.append("update_time:\"").append(result.getString(4)).append("\",");
//    		    		  json.append("soft_language:\"").append(result.getString(5)).append("\",");
//    		    		  json.append("soft_version:\"").append(result.getString(6)).append("\",");
//    		    		  json.append("soft_download_count:").append(result.getString(7)).append(",");
//    		    		  json.append("introduce:\"").append(result.getString(10)).append("\",");
//    		    		  json.append("size:").append(result.getInt(11));
//    		    		  json.append("},");
//    			      }
//    					
    			      json.deleteCharAt(json.length()-1);
    		    	  json.append(']');
    		    	  dbService.CloseAll();	  
    		    	  return json.toString();
    					
    			
    	  }
    	  catch(SQLException e){
    		  e.printStackTrace();
    	  }
    	  
    	  return null;
      }
      
//      public String operate_register(HttpServletRequest request){
//    	  Statement stat;
//    	  try{
//    		String json ;
//			String id = new String( request.getParameter("ID").getBytes("ISO8859-1"),"UTF-8");
//    		String password = new String( request.getParameter("password").getBytes("ISO8859-1"),"UTF-8");
//    		String dev_name = new String( request.getParameter("dev_name").getBytes("ISO8859-1"),"UTF-8");
//    		int dev_age =Integer.parseInt( request.getParameter("age"));
//            int dev_gender = Integer.parseInt(request.getParameter("gender"));
//            String company =new String( request.getParameter("company").getBytes("ISO8859-1"),"UTF-8");
//            String address = new String( request.getParameter("address").getBytes("ISO8859-1"),"UTF-8");
//            String pho = request.getParameter("pho");
//            
//    		stat = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//  			String sql ="insert developer values ('"+id+"', '"+password+"', '"+dev_name+"', "+
//  			            dev_age+" ,"+dev_gender+",'"+company+"', '"+address+"', '"+pho+"' )";
//  			System.out.println(sql);
//  		    stat.execute(sql);
//  			json = "[{operage:\"ok\"}]";
//  			stat.close();
//  			return json;
//  			
//    	  }catch(SQLException e){
//    		  e.printStackTrace();
//    		  //������쳣һ�㶼��id�ظ��ˡ���
//    		  return null;
//    	  } catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	  return null;
//      }
//      //���ߵ�������Ʒ
//      public String auther_otherworks(HttpServletRequest request){
//    	   Statement stat;
//    	   ResultSet result;
//    	  try{
//    		  String id = new String( request.getParameter("ID").getBytes("ISO8859-1"),"UTF-8");
//    		  stat = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//    		  String sql ="select * from software where dev_id = "+id;
//    		  result = stat.executeQuery(sql);
//    		  StringBuilder json = new StringBuilder();
//    		  json.append( "[{operage:\"auther_other_software\"},");
//    		  while(result.next()){
//    			  json.append('{');
//	    		  json.append("id:").append(result.getInt(1)).append(",");
//	    		  json.append("soft_name:\"").append(result.getString(2)).append("\",");
//	    		  json.append("dev_name:\"").append(get_devname(result.getString(3))).append("\",");
//	    		  json.append("dev_id:\"").append(result.getString(3)).append("\",");
//	    		  json.append("update_time:\"").append(result.getString(4)).append("\",");
//	    		  json.append("soft_language:\"").append(result.getString(5)).append("\",");
//	    		  json.append("soft_version:\"").append(result.getString(6)).append("\",");
//	    		  json.append("soft_download_count:").append(result.getString(7)).append(",");
//	    		  json.append("introduce:\"").append(result.getString(10)).append("\",");
//	    		  json.append("soft_size:").append(result.getInt(11));
//	    		  json.append("},"); 	
//    		  }
//    		  json.append("{operate:\"auther_other_game\"},");
//    		  sql = "select * from game where dev_id = "+id;
//    		  result = stat.executeQuery(sql);
//	    	 while(result.next()){
//	    		  json.append('{');
//	    		  json.append("id:").append(result.getInt(1)).append(",");
//	    		  json.append("game_name:\"").append(result.getString(2)).append("\",");
//	    		  json.append("dev_name:\"").append(get_devname(result.getString(3))).append("\",");
//	    		  json.append("dev_id:\"").append(result.getString(3)).append("\",");
//	    		  json.append("update_time:\"").append(result.getString(4)).append("\",");
//	    		  json.append("soft_language:\"").append(result.getString(5)).append("\",");
//	    		  json.append("soft_version:\"").append(result.getString(6)).append("\",");
//	    		  json.append("soft_download_count:").append(result.getString(7)).append(",");
//	    		  json.append("introduce:\"").append(result.getString(10)).append("\",");
//	    		  json.append("size:").append(result.getInt(11));
//	    		  json.append("},");
//		      }
//			
//	      json.deleteCharAt(json.length()-1);
//    	  json.append(']');
//    	  stat.close();
//          result.close();	    	  
//    	  return json.toString();
//			
//    		  
//    	  }catch(SQLException  o){
//    		 o.printStackTrace();
//    	  } catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	  
//    	  return null;
//      }
//      //��ȡ����
//      public String get_estimate(HttpServletRequest request){
//    	  Statement stat;
//   	      ResultSet result;
//    	  try{
//    		  String table = request.getParameter("table");
//    		  String ID = request.getParameter("ID");
//    		  stat = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//    		  String sql = "select * from "+table+" where id = "+ID;
//              result = stat.executeQuery(sql);
//              StringBuilder json = new StringBuilder();
//              json.append("[{operage:\"estimate\"},");
//              while(result.next()){
//            	  json.append("{estimate:\"").append(result.getString(2)).append("\"},");
//            	  
//              }
//              json.deleteCharAt(json.length()-1);
//        	  json.append(']');
//        	  stat.close();
//              result.close();	    	  
//        	  return json.toString();
//    	  }catch(SQLException e){
//    		  e.printStackTrace();
//    	  }
//    	  
//    	  return null;
//      }
//      
//      
//      //�ö�����  �ͱ���������
//      public String why_hate(HttpServletRequest request){
//    	  Statement stat;
//   	      ResultSet result;
//   	      try{
//   	    	 String table = request.getParameter("table");
//   	    	 String ID = request.getParameter("ID");
//   	    	 int why = Integer.parseInt(request.getParameter("why"));
//   	    	 String describe = request.getParameter("describe");
//   	    	 stat = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//   	    	 byte temp[] = new byte[5]; 
//   	    	 for(int i = 0 ; i < 5 ;i++){
//   	    		 int get_ = why & 1;
//   	    		 temp[i] = (byte)get_;
//   	    		 why = why>>1;
//   	    	 }
//  		     String sql = "insert into  "+table+" values ("+ID+","+temp[0]+","+temp[1]+","+temp[2]+","+temp[3]+","+temp[4]+",'"
//  		    		                     +describe+"')";
//  		     System.out.println(sql);
//  		    result = stat.executeQuery(sql);
//			StringBuilder json = new StringBuilder();
//			json.append("[{operage:\"hate\"}]");
//
//			stat.close();
//			result.close();	    	  
//   	       return json.toString();
//   	      }catch(Exception e ){
//   	    	  
//   	      }
//   	      
//   	      return null;
//      }
//      
//      
//      
//      //��������ظ�
//      public String Search(HttpServletRequest request){
//    	  Statement stat;
//   	      ResultSet result_ ;
//    	  String keywords = null;
//		try {
//			keywords = new String( request.getParameter("keywords").getBytes("ISO8859-1"),"UTF-8");
////			keywords = request.getParameter("keywords").getBytes("UTF-8");
//			System.out.println("keywords "+keywords);
//			String sql_ = "select * from software where soft_name like '%"+keywords+"%'";//��keywords��ͷ
//			String sql_game = "select * from Game where game_name  like '%"+keywords+"%'";
//			String sql_amusement = "select * from amusement where file_name  like '%"+keywords+"%'";
//			stat = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			result_ = stat.executeQuery(sql_);
//			StringBuilder json =new StringBuilder();
//			json.append( "[{operage:\"search\"},{get_operate:\"software\"},");
//			while(result_.next()){
//			    json.append('{');
//			    json.append("id:").append(result_.getInt(1)).append(",");
//			    json.append("soft_name:\"").append(result_.getString(2)).append("\",");
//			    json.append("dev_name:\"").append(get_devname(result_.getString(3))).append("\",");
//			    json.append("dev_id:\"").append(result_.getString(3)).append("\",");
//			    json.append("update_time:\"").append(result_.getString(4)).append("\",");
//			    json.append("soft_language:\"").append(result_.getString(5)).append("\",");
//			    json.append("soft_version:\"").append(result_.getString(6)).append("\",");
//			    json.append("soft_download_count:").append(result_.getString(7)).append(",");
//			    json.append("introduce:\"").append(result_.getString(10)).append("\",");
//			    json.append("soft_size:").append(result_.getInt(11));
//			    json.append("},");
//			}
//			result_ = stat.executeQuery(sql_game);
//			json.append("{get_operate:\"game\"},");
//			 while(result_.next()){
//	    		  json.append('{');
//	    		  json.append("id:").append(result_.getInt(1)).append(",");
//	    		  json.append("game_name:\"").append(result_.getString(2)).append("\",");
//	    		  json.append("dev_name:\"").append(get_devname(result_.getString(3))).append("\",");
//	    		  json.append("dev_id:\"").append(result_.getString(3)).append("\",");
//	    		  json.append("update_time:\"").append(result_.getString(4)).append("\",");
//	    		  json.append("soft_language:\"").append(result_.getString(5)).append("\",");
//	    		  json.append("soft_version:\"").append(result_.getString(6)).append("\",");
//	    		  json.append("soft_download_count:").append(result_.getString(7)).append(",");
//	    		  json.append("introduce:\"").append(result_.getString(10)).append("\",");
//	    		  json.append("size:").append(result_.getInt(11));
//	    		  json.append("},");
//	    	  
//	    	  }
//			 result_ = stat.executeQuery(sql_amusement);
//			 json.append("{get_operate:\"amusement\"},");
//			 while(result_.next()){
//	    		  json.append('{');
//	    		  json.append("id:").append(result_.getInt(1)).append(",");
//	    		  json.append("file_name:\"").append(result_.getString(2)).append("\",");
//	    		  json.append("dev_name:\"").append(get_devname(result_.getString(3))).append("\",");
//	    		  json.append("dev_id:\"").append(result_.getString(3)).append("\",");
//	    		  json.append("update_time:\"").append(result_.getString(5)).append("\",");
//	    		  json.append("download_count:").append(result_.getString(7)).append(",");
//	    		  json.append("introduce:\"").append(result_.getString(8)).append("\",");
//	    		  json.append("classify:\".").append(result_.getString(4)).append("\",");
//	    		  json.append("size:").append(result_.getInt(9));
//	    		  json.append("},");
//	    	  
//	    	  }
//			  json.deleteCharAt(json.length()-1);
//        	  json.append(']');
//        	  stat.close();
//              result_.close();	    	  
//        	  return json.toString();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//    	  
//    	  return null;
//      }
//      
//      
//      
//      
//      private String get_devname(String id ){
//    	  String sql = "select dev_name from developer where id =" +id; 
//    	 
//    	  ResultSet result_ = null;
//    	  try {
//    		 Statement state = dbConn.createStatement();
//			 result_ = state.executeQuery(sql);
//			 result_.next();
//			 String get = result_.getString(1);
//			 result_.close();
//			 state.close();
//			 return get;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	 
//    	  
//    	  return null;
//      }
      
      
}













