package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.User;
import util.DbConnection;

public class UserDaoImpl implements UserDao{

	Connection conn=DbConnection.getDb();

	@Override
	public void insert(User user) {
		String sql="insert into user(account,password,name,role_id)"+
					"values(?,?,?,?)";
		
		try (PreparedStatement ps =conn.prepareStatement(sql)){

	        ps.setString(1, user.getAccount());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getName());
	        ps.setInt(4, user.getRoleId());
	        
	        ps.executeUpdate();
	        
		}catch(Exception e) {
			 e.printStackTrace();
		}
	}

	@Override
	public List<User> selectAll() {
		
		List<User>list = new ArrayList<>();
		
		String sql="select * from user";
		
		try (PreparedStatement ps=conn.prepareStatement(sql)){
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				User user = new User();
				
				user.setUserId(rs.getInt("user_id"));
	            user.setAccount(rs.getString("account"));
	            user.setPassword(rs.getString("password"));
	            user.setName(rs.getString("name"));
	            user.setRoleId(rs.getInt("role_id"));
	            Timestamp ts = rs.getTimestamp("create_time");
	            
	            if(ts != null)
	            {
	            	user.setCreateAt(ts.toLocalDateTime());
	            }
				
	            list.add(user);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public User selectByAccount(String account) {
		User user=null;
		String sql="select * from user where account = ?";
		
		try (PreparedStatement ps=conn.prepareStatement(sql)){
			
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				
	            user.setUserId(rs.getInt("user_id"));
	            user.setAccount(rs.getString("account"));
	            user.setPassword(rs.getString("password"));
	            user.setName(rs.getString("name"));
	            user.setRoleId(rs.getInt("role_id"));
	            Timestamp ts = rs.getTimestamp("create_time");
	            
	            if(ts != null)
	            {
	            	user.setCreateAt(ts.toLocalDateTime());
	            }
	            
	            return user;
	            
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public User selectByName(String name) {
		User user=null;
		String sql =
				"select * from user where name=?";
		
		try (PreparedStatement ps=conn.prepareStatement(sql))
		{
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				
	            user.setUserId(rs.getInt("user_id"));
	            user.setAccount(rs.getString("account"));
	            user.setPassword(rs.getString("password"));
	            user.setName(rs.getString("name"));
	            user.setRoleId(rs.getInt("role_id"));
	            Timestamp ts = rs.getTimestamp("createAt");
	            
	            if(ts != null)
	            {
	            	user.setCreateAt(ts.toLocalDateTime());
	            }
	            
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void update(User user) {
	    String sql =
	            "UPDATE user " +
	            "SET account=?, password=?, name=?, role_id=? " +
	            "WHERE user_id=?";
	    
	    try (PreparedStatement ps= conn.prepareStatement(sql)) 
	    {
	    	ps.setString(1, user.getAccount());
	    	ps.setString(2, user.getPassword());
	    	ps.setString(3, user.getName());
	    	ps.setInt(4, user.getRoleId());
	    	ps.setInt(5, user.getUserId());
	        
	        ps.executeUpdate();
	    	
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void delete(int userId) {
		String sql = 
				"DELETE FROM user WHERE user_id=?";
		
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, userId);
			
			ps.executeUpdate();

		}catch (SQLException e) {
	        e.printStackTrace();
		}

	}

}
