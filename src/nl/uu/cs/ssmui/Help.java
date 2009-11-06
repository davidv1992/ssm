/* 	Help.java	Title:			Simple Stack Machine Runner	Author:			atze	Description:	*/package nl.uu.cs.ssmui;//import javax.swing.*;import java.util.* ;import nl.uu.cs.ssm.* ;public class Help {	private Vector helpSuppliers ;		public Help()	{		helpSuppliers = new Vector() ;	}		public void addHelpSupplier( HelpSupplier hs )	{		helpSuppliers.addElement( hs ) ;	}		private static void addSorted( Vector v, HelpTopic ht )	{	    int max = v.size() ;	    int i ;	    for ( i = 0 ; i < max ; i++ )	    {	        if ( ht.toString().toLowerCase().compareTo( v.elementAt(i).toString().toLowerCase() ) < 0 )	            break ;	    }	    if ( i >= max )	        v.addElement( ht ) ;	    else	        v.insertElementAt( ht, i ) ;	}		public Vector findTopics( String key )	{		Vector topics = new Vector() ;		if ( key != null )    		key = key.toLowerCase() ;				for ( Enumeration hss = helpSuppliers.elements() ; hss.hasMoreElements() ; )		{			HelpSupplier hs = (HelpSupplier)hss.nextElement() ;			for ( Enumeration ts = hs.getTopics() ; ts.hasMoreElements() ; )			{				String t = (String)ts.nextElement() ;				if ( key == null || t.toLowerCase().indexOf( key ) >= 0 )    				addSorted( topics, new HelpTopic( hs, t ) ) ;			}		}				return topics ;	}		}