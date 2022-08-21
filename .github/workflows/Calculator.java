import java.awt.*;
import java.awt.event.*;
public class Calculator {
public static void main(String[] args) {
Calc op=new Calc("Ahmed esam");
op.setBounds(50, 50, 280, 420);
op.setVisible(true);
    }    }

    
 class Calc extends Frame implements ActionListener {
    Button []b=new Button[18];
    Label l;
    double result;
    boolean nd=false;
    String s2="",t;
    Calc(String name){
        super(name);
        setLayout(null);
        setBackground(Color.black);
        int x=10,y=80;
        for(int i=0;i<10;i++){
            b[i]=new Button(String.valueOf(i));
            if(i==0){
                b[i].setBounds(x, 290, 50, 50);
            }
            else{
            b[i].setBounds(x, y,50 ,50);
            x+=70;
            if(i%3==0){
                y+=70;
                x=10;
            }
            
            }
                        add(b[i]);
                        b[i].addActionListener(this);

        }
        x=220;y=80;
        b[15]=new Button("CLZ");
        b[15].setBounds(x, y,50 ,50);
        b[10]=new Button("+");
        b[10].setBounds(x, y+=70,50 ,50);
        b[11]=new Button("-");
        b[11].setBounds(x, y+=70,50 ,50);
        b[12]=new Button("*");
        b[12].setBounds(x, y+=70,50 ,50);
        b[13]=new Button("/");
        b[13].setBounds(x-=70, y,50 ,50);
        b[17]=new Button(".");
        b[17].setBounds(x-=70, y,50 ,50);
        b[14]=new Button("=");
        b[14].setBounds(x-=70, y+=70,120 ,50);
        b[16]=new Button("CLR");
        b[16].setBounds(x+=140, y,120 ,50);
      for(int i=10;i<18;i++){
          add(b[i]);
          b[i].addActionListener(this);
      }
      l=new Label();
      l.setBounds(10, 30, 410, 50);
      l.setBackground(Color.white);
      add(l);
        this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    }
    @Override
    public void processWindowEvent(WindowEvent evt){
        if(evt.getID()==WindowEvent.WINDOW_CLOSING)
            System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s ;       
        s=e.getActionCommand();
        
        switch(s){
            case "0":case "1":case "2":case "3":case "4":case "5":case "6":case "7":
            case "8":case "9":
                s=l.getText()+s;
                l.setText(s);
                break;
            case "+":
                        t=s;

                if(s.equals("")&&s2.equals(""));
                else{
                    if(!nd){
                    result+= Double.valueOf(l.getText());
                    s=l.getText()+" "+s+" ";
                    s2=s;
                    l.setText(s);
                    nd=true;
                    }
                    else{
                        result+=Double.valueOf(l.getText().substring(s2.length()-1 ));
                        s=result+" "+s+" ";
                        s2=s;
                        l.setText(s);
                    }
                }
                break;
            case "CLR":
                l.setText("");
                s2="";
                result=0;
                nd=false;
                break;
            case "-":
                t=s;
                if(s.equals("")&&s2.equals(""));
                else{
                    if(!nd){
                    result= Double.valueOf(l.getText());
                    s=l.getText()+" "+s+" ";
                    s2=s;
                    l.setText(s);
                    nd=true;
                    }
                    else{
                        result-=Double.valueOf(l.getText().substring(s2.length()-1 ));
                        s=result+" "+s+" ";
                        s2=s;
                        l.setText(s);
                    }
                }
                break;
            case "=":
                if(s2!=""){
               result= c(result,Double.valueOf(l.getText().substring(s2.length()-1)),t);
                l.setText(""+result);
                nd=false;
                result=0;
                s2="";
                }
                break;
            case "CLZ":
                System.exit(0);
                break;
            case "/":
                 t=s;
                if(s.equals("")&&s2.equals(""));
                else{
                    if(!nd){
                    result= Double.valueOf(l.getText());
                    s=l.getText()+" "+s+" ";
                    s2=s;
                    l.setText(s);
                    nd=true;
                    }
                    else{
                        try{
                        result/=Double.valueOf(l.getText().substring(s2.length()-1 ));
                        s=result+" "+s+" ";
                        s2=s;
                        l.setText(s);
                    }
                        catch(Exception ex){
                            l.setText("Wrong");
                        }
                    }
                }
                break;
            case "*":
                 t=s;
                if(s.equals("")&&s2.equals(""));
                else{
                    if(!nd){
                    result= Double.valueOf(l.getText());
                    s=l.getText()+" "+s+" ";
                    s2=s;
                    l.setText(s);
                    nd=true;
                    }
                    else{
                        result*=Double.valueOf(l.getText().substring(s2.length()-1 ));
                        s=result+" "+s+" ";
                        s2=s;
                        l.setText(s);
                    }
                }
                break;
            case ".":
                l.setText(l.getText()+".");
                break;
        }
        }
    double c(double a,double b,String s){
        double r=0;
        switch(s){
            case "+":
              r=a+b;break;
            case "-":
                r=a-b;break;
            case "*":
                r=a*b;break;
                case "/":
                try{
                r=a/b; break;
        }
            catch(Exception e){
                l.setText("Wrong");
            }
                    break;
                default :
                    
        }
        return r;
    }
    }  

