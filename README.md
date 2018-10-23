

##### Spring Boot HTTP over JSON 的错误码异常处理
https://www.bysocket.com/?p=1692
######异常统一处理的使用场景
    
#####Json数据序列化和反序列化的问题：（在众包质检项目遇到了这个问题？目前还没有比较好的方法）
    json序列化的时候涉及容易出现的问题：
    
    	空字符串和null值序列化策略，因为有时候需要判断是否为null，有时候需要判断是否为null和空字符串。还有控制字段是否参与序列化问题。
    	比如：null是否参与序列化？、序列化""或null？同样""是否参与序列化？、序列化为null或""？,控制一些字段（可以是null或""）是否参与序列化?
    	
    反序列化时也是同样的问题：
    
    	反序列化往往会不一样，因为有时候时是接口开发，我们不知道或者不好控制别人的序列化策略。
    	那么我们就需要根据我们的业务来指定反序列化策略。
###### Mysql与java的数据类型对应关系
        常用数据类型：
        int                 Integer
        bigint              Long
    	bigint unsigned     BigInteger
    	varchar                    String
    	Mysql 与 java 的时间类型 
        MySql的时间类型有 Java中与之对应的时间类型 
          date                 java.sql.Date 
          datetime          java.sql.Timestamp 
          timestamp       java.sql.Timestamp 
          time                 java.sql.Time 
          year                 java.sql.Date 
  
        转换相互转换：
        Date date = new Date();//获得系统时间. 
        String nowTime = new SimpleDateFormat(“yyyy-MM-dd HH:mm:ss”).format(date);
        Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换 
        java.util.Date 是java.sql.Date的父类
        --------------------- 
        作者：fostlin 
        来源：CSDN 
        原文：https://blog.csdn.net/fouling/article/details/79745468 
        版权声明：本文为博主原创文章，转载请附上博文链接！
        
Web项目接口测试：
参考教程：https://blog.csdn.net/q1512451239/article/details/53411393?utm_source=blogxgwz0
