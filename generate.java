import java.awt.Color;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
class Captcha 
{
 public String generateCaptcha() 
{
 Random random = new Random();
 int length=8+(Math.abs(random.nextInt()))%8;
 StringBuffer captchaStringBuffer = new StringBuffer();
 for (int i = 0;i<length ; i++) 
 {
   int captchaNumber = Math.abs(random.nextInt()) % 60;
   int charNumber = 0;
   if (captchaNumber < 26)
  {
    charNumber = 65 + captchaNumber;
   }
   else if (captchaNumber < 52)
   {
    charNumber = 97 + (captchaNumber - 26);
   }
   else 
   {
    charNumber = 48 + (captchaNumber - 52);
   }
   captchaStringBuffer.append((char)charNumber);
  }
 return captchaStringBuffer.toString();
}
}
public class generate
{
 public static void main(String args[])

 {
String ps="";
int arr3[]=new int[16];
  Captcha captcha = new Captcha();
  String str = captcha.generateCaptcha(); 
  String name = str+'.';
  System.out.println(name);
  int nameLenght =name.length(); 

int arr[] =new int[16];

  for(int i = 0; i < nameLenght ; i++)
  {
        char character = name.charAt(i); 
        int ascii = (int) character; 
        //System.out.println(ascii);
	arr[i]=ascii;
	System.out.println(ascii);
  }
  //System.out.println(ascii);
  int asciii, onecount = 0,zerocount=0, a;
      
  String x = "";
    
int i=0,flag;
int bin[]=new int[8];
int k=0;
int pos[]=new int[4];

System.out.println("length:"+arr.length);
for(int h=0;h<arr.length;h++)
{ 
int asc=arr[h];
if(asc>0){
  int j=6;  

System.out.println("ASCII:"+asc);
  while(asc > 0)
     
   {
     
       a = asc % 2;
     
       if(a == 1)
          
       {
 	bin[j]=a;              
         onecount++; 
         System.out.println("bin["+j+"]="+bin[j]);   
           
       }

       else
       {
	bin[j]=a;
         zerocount++;
System.out.println("bin["+j+"]="+bin[j]);
       }        
// x = a + "" + x;

j--;            
    asc= asc/ 2;
    //System.out.println(j);  
}//while
while(j>=0){
System.out.println(j);   
bin[j]=0;
System.out.println("bin["+j+"]="+bin[j]);   
j--;
}//while

if(onecount<zerocount){
flag=1;
}else{
flag=0;
}
k=0;
pos[k]=flag;
k++;
for(i=0;i<7;i++){
if(bin[i]==flag){
pos[k]=i+1;
k++;
}//if
}//for
while(k<4){
pos[k]=0;
k++;
}//if
System.out.println("k:"+k);
System.out.println("No. of 1s:"+onecount);
System.out.println("No. of 0s:"+zerocount);
onecount = 0;
zerocount=0;
System.out.println("Binary:");
for(i=0;i<=6;i++){
System.out.print(bin[i]);
}//for
System.out.println();
for(i=0;i<=3;i++){
ps+=String.valueOf(pos[i]);
 System.out.println("position:"+pos[i]);
}//for
}//if
else{
continue;
}
}//for
System.out.println("ps:"+ps); 
embed(ps);
}//main
static void embed(String ps){
char ps1[]=ps.toCharArray();
int l=0,s;
try{
File f=new File("C:\\Users\\Haritha\\Pictures\\Screenshots\\pic.png");
BufferedImage img=ImageIO.read(f);
for(int i=0;i<img.getHeight();i++){
for(int j=0;j<img.getWidth();j++){
Color c=new Color(img.getRGB(j,i));
int red=c.getRed();
int green=c.getGreen();
int blue=c.getBlue();
s=ps1.length;
if(l<s){
System.out.println("s:"+s);
System.out.println("i:"+i+"j:"+j+"l:"+l);

if(l%4==0)
{
//System.out.println("x readed");
System.out.println("ps1:"+(ps1[l]%2)+"r1:"+(red%2));
if(ps1[l]%2==0 && red%2==1){
System.out.println("i:"+j+"red: "+red);
red=red+1;
System.out.println("red: "+red);
}
if(ps1[l]%2==1 && red%2==0){
System.out.println("i:"+j+"red: "+red);
red=red+1;
System.out.println("red: "+red);
//l++;
}
Color newCo=new Color(red,green,blue);
img.setRGB(j,i,newCo.getRGB()); 
}
else{
//System.out.println("y readed");
String bin=binary(ps1[l]);
char b[]=bin.toCharArray();
System.out.println("bin: "+bin);
System.out.println("b0:"+(b[0]));
System.out.println("b1:"+(b[1]));
System.out.println("b2:"+(b[2]));
System.out.println("red:"+(red%2));
System.out.println("green:"+(green%2));
System.out.println("blue:"+(blue%2));
if(b[0]=='0' && red%2==1){
System.out.println("i:"+j+"red: "+red);
red=red+1;
System.out.println("red: "+red);
}
if(b[0]=='1' && red%2==0){
System.out.println("i:"+j+"red:"+red);
red=red+1;
System.out.println("red: "+red);
}
if(b[1]=='0' && green%2==1){
System.out.println("i:"+j+" green: "+ green);
green=green+1;
System.out.println("green: "+green);
}
if(b[1]=='1' && green%2==0){
System.out.println("i:"+j+"green: "+green);
green=green+1;
System.out.println("green: "+green);
//l++;
}
if(b[2]=='0' && blue%2==1){
System.out.println("i:"+j+"blue: "+blue);
blue= blue+1;
System.out.println("blue: "+blue);
}
if(b[2]=='1' && blue%2==0){
System.out.println("i:"+j+"blue: "+blue);
blue=blue+1;
System.out.println("blue: "+blue);
//l++;
}
Color newCo=new Color(red,green,blue);
img.setRGB(j,i,newCo.getRGB());
}//else
l++;
}//if
else{
Color newCo=new Color(red,green,blue);
img.setRGB(j,i,newCo.getRGB());
}
}//for j
}//for i
File output=new File("C:\\Users\\Haritha\\Pictures\\Screenshots\\stegop.png");
ImageIO.write(img,"png",output);
}catch(IOException e){e.printStackTrace();}
}
static String binary(char num1){
int num=Character.getNumericValue(num1);
String bin1="",bin2="";
System.out.println("num: "+num);
while(num>0){
if(num%2==1){
bin1+='1';
}//if
else{
bin1+='0';
}//else
num=num/2;
}
bin1=level(bin1);
//System.out.println("bin1: "+bin1);
//bin2+=bin1;
return bin1;
}
static String level(String bin){
String s="";
char[]b=bin.toCharArray();
int n,r;
r=b.length-1;
for(n=0;n<r;n++,r--){
char temp=b[n];
b[n]=b[r];
b[r]=temp;
}
s=String.valueOf(b);
while(s.length()<3){
s='0'+s;
}
System.out.println("s: "+s);
return s;
}

}//class
