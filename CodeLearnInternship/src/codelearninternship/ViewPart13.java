package codelearninternship;

//import javax.swing.table.TableColumn;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class ViewPart13 extends ViewPart {
	 private static URL URLObj;
	  
     private static URLConnection connect;
	public ViewPart13() {
		// TODO Auto-generated constructor stub
	}

	int totalcount=0;
	String[] time=new String[200];
	String[] city={"bangalore","chennai","delhi","mumbai","goa","cochin","hyderabad","ahmedabad"};
	@Override
	public void createPartControl(final Composite parent) 
	{
		final	Table table ;
		   parent.setLayout(new GridLayout(3,false));
	        Label label = new Label(parent, SWT.NONE);
			label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
					false));
			label.setText("From");
			
			
			final	Text SenderEmail = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
			SenderEmail.setLayoutData(new GridData(200,20));
			SenderEmail.setText("");
			
		final Label Elabel = new Label(parent, SWT.NONE);
			Elabel.setLayoutData(new GridData(200,20));
			Elabel.setText("");
			
			
			
			final Label label1 = new Label(parent, SWT.NONE);
			label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
					false));
			label1.setText("To");
			
			final Text Subject = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
			Subject.setLayoutData(new GridData(200,20));
			Subject.setText("");
			
			final Label Elabel1 = new Label(parent, SWT.NONE);
			Elabel1.setLayoutData(new GridData(200,20));
			Elabel1.setText("");

			//Elabel.setForeground();
			org.eclipse.swt.widgets.Button button = new org.eclipse.swt.widgets.Button(
					parent, SWT.PUSH);
			button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
					false));
			button.setText("Send");
			
			final Label Elabel2 = new Label(parent, SWT.NONE);
			Elabel2.setLayoutData(new GridData(200,20));
			Elabel2.setText("");
			
		
			parent.setLayout( new GridLayout(1,false));
		table = new Table(parent ,SWT.NONE);
			table.setVisible(false);
	        table.setLinesVisible(true);
	        table.setHeaderVisible(true);
	        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
	        data.heightHint = 200;
	        table.setLayoutData(data);

	  final      String[] titles = { "From", "To", "Airline","FlightNo","Depart-Arrive" };
	        for (int i = 0; i < titles.length; i++) {
	            TableColumn column = new TableColumn(table, SWT.NONE);
	            column.setText(titles[i]);
	            table.getColumn(i).pack();
	        }
	        
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					String b="true";//validate(SenderEmail.getText().trim());
					
					
					if(check(SenderEmail.getText())==false )
					{
						Elabel.setText("invalid");
					}
					else if(check(Subject.getText())==false)
					{
						Elabel1.setText("invalid");
					}
					
					else if(cmp(SenderEmail.getText(),Subject.getText())==false)
					{
						Elabel.setText("Same");
						Elabel1.setText("Same");
						
						//Elabel2.setText("");
						//check(SenderEmail.getText(),Subject.getText());
						
					}
					else
					{
						Elabel.setText("");
						Elabel1.setText("");
						
						/*if(totalcount !=0)
						{
							 for (int i = 0 ; i<=totalcount ; i++){
								 table.remove(i);
							 }
								    
						}*/
						table.removeAll();
						
						totalcount=0;
						
					getTime(SenderEmail.getText(), Subject.getText());
					
					 for (int i = 0 ; i<=totalcount-1 ; i+=5){
				            TableItem item = new TableItem(table, SWT.NONE);
				            item.setText (0, time[i]);
				          item.setText (1, time[i+1]);
				            item.setText (2, time[i+2]);
				            item.setText (3, time[i+3]);
				            item.setText (4, time[i+4]);
				            
				            
				            
				        }
				        
				        for (int i=0; i<titles.length; i++) {
				            table.getColumn (i).pack ();
				        }    
				        
						table.setVisible(true);
						
					}
					
					
					
				}
			});
			
			
			
			
			
	}
	
	public void getTime(String from,String to)
	{
		
		 try {
			 // private static URL URLObj;
			  
			      

	            // Establish a URL and open a connection to it. Set it to output mode.
	           URL URLObj = new URL("http://www.makemytrip.com/flights/"+from.toLowerCase()+"-"+to.toLowerCase()+"-cheap-airtickets.html");
	            connect = URLObj.openConnection();
	            connect.setDoOutput(true);	
	        }
	     
	        catch (Exception ex) 
	        {
	            System.out.println("An exception occurred. " + ex.getMessage());
	            System.exit(1);
	        }
			
			
	        try 
	        {
	           
				
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				
	            String lineRead = "";
				
	            // Read all available lines of data from the URL and print them to screen.
	            while ((lineRead = reader.readLine()) != null) 
	            {
	            	
	            	if(lineRead.contains("  <tr ") ==true)
	            	{
	            		lineRead=reader.readLine();
	            	int count=0;
	            	while(count<=4)
	            	{
	            	String 	s=lineRead.substring(lineRead.indexOf(">")+1,lineRead.lastIndexOf("<"));
	                time[totalcount]=s;
	                totalcount++;
	            	//System.out.print(s+" ");
	                
	                lineRead=reader.readLine();
	                count++;
	            	}
	            	System.out.println();
	            }
				
	            
	        }
	            reader.close();
	            
	        }
	            
	        catch (Exception ex) {
	            System.out.println("There was an error reading or writing to the URL: " + ex.getMessage());
	        }
		
		
	}

	public boolean cmp(String from,String to)
	{
		if(from.toLowerCase().equals(to.toLowerCase())==true)
				{
			return false;
				}
		else
		{
			return true;
		}
	}
	
	public boolean check(String s)
	{
			boolean avail=false;
			
		if(s.trim().equals("")){return false;}
		
		

		for(int i=0;i<7;i++)
		{
		if(city[i].equals(s.toLowerCase().trim())==true)
		{
			avail=true;
			break;
		}
		}	
		if (s.toLowerCase().matches("[a-z]+$")==false) {
			   return false;
			}
	     
		if(avail==false){return false;}

		return true;
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
