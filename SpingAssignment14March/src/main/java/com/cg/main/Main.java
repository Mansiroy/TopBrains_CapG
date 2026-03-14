package com.cg.main;

    import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	import com.cg.bean.Librarian;
	//import com.cg.bean.Book;

	public class Main {

		    public static void main(String[] args) {
		    	
		    	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		    	Librarian librarian = (Librarian)ctx.getBean("librarianBean");
		    	librarian.issueBook();

		    	
		    }
		}



