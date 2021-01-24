import java.awt.Color;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
class Extract1
{

public static void main (String args[])
{
int flag;
String captcha="";	
//String ps1[]=new String[64];
	String ps="";
	String bin="";
	int l=0;
	String num="";
try{

File input=new File("C:\\Users\\Haritha\\Pictures\\Screenshots\\stegop.png");
BufferedImage img=ImageIO.read(input);
for(int i=0;i<img.getHeight();i++){
for(int j=0;j<img.getWidth();j++){
int b[]=new int[3];
Color c=new Color(img.getRGB(j,i));
int red=c.getRed();
int green=c.getGreen();
int blue=c.getBlue();
if(l<64){
if(l%4==0)
{
//ps="";
flag=red%2;
System.out.println("flag:"+flag);
ps+=String.valueOf(flag);
System.out.println("ps:"+ps);
//ps1[l]=(char)flag;
}
else
{
//bin="";
bin=String.valueOf(red%2);
bin+=green%2;
bin+=blue%2;
//String bin=b.toString();
System.out.println("bin:"+bin);
int dec=Integer.parseInt(bin,2);
System.out.println("dec:"+dec);
ps+=String.valueOf(dec);
//ps1[l]=(char)dec;
//System.out.println("ps11"+ps1[l]);
}//else
l++;
}//if
}//for j
}//for i
}//try
catch(IOException e)
{
e.printStackTrace();
}//catch
char ps1[]=ps.toCharArray();
System.out.println("l:"+l);
l=0;
char f;
while(l<64){
int k,num1;
//System.out.println("char:"+ps.charAt(l));
if(l%4==0){
//f=0;
System.out.println("k1 readed");
f=ps1[l];
System.out.println("f:" +ps1[l]);
System.out.println("f:" +f);
k=0;
l++;
num="";
if(f=='0'){
System.out.println("flag 0 readed");
for(int m=1;m<=7;m++){
System.out.println("ps1:"+ps1[l]);
System.out.println("k:"+k);
if(k<3){
System.out.println("k1:"+k);
System.out.println("m:"+m);
System.out.println((int)ps1[l]-48);
System.out.println("l:"+l);	
if(m==((int)ps1[l]-48)){
System.out.println("l:"+l);
num+='0';
k++;
System.out.println("k1 incremented");
l++;
}
else{
num+='1';
System.out.println("m:"+m);
System.out.println("l:"+l);
}

System.out.println("num:"+num);
}
System.out.println("num:"+num.length());
}//for

if(k<3){
l++;
k++;
//System.out.println("m:"+m);
System.out.println("l:"+l);
}
while(num.length()<7){
System.out.println("Number Readed");
num=num+'1';
System.out.println("num:"+num);
}

System.out.println("num:"+num);
}//if
else if(f=='1'){
System.out.println("flag 1 readed");
for(int m=1;m<=7;m++){
System.out.println("ps1:"+ps1[l]);
System.out.println("k:"+k);
if(k<3){
System.out.println("k1:"+k);
System.out.println("m:"+m);
System.out.println((int)ps1[l]-48);
System.out.println("l:"+l);	
if(m==((int)ps1[l]-48)){
System.out.println("l:"+l);
num+='1';
k++;
System.out.println("num:"+num);
System.out.println("k1 incremented");
l++;
}
else{
num+='0';
System.out.println("else incremented");
System.out.println("num:"+num);
System.out.println("m:"+m);
System.out.println("l:"+l);
}

System.out.println("num:"+num);
}
}//for
if(k<3){
l++;
k++;
//System.out.println("m:"+m);
System.out.println("k:"+k);
System.out.println("l:"+l);
}

System.out.println("num:"+num);
System.out.println("num:"+num.length());
num1=Integer.parseInt(num,2);
System.out.println("num1:"+num1);
//int count=0;
while(num.length()<7){
System.out.println("ooooo incremented");
num=num+'0';
System.out.println("num:"+num);
}
}//if
num1=Integer.parseInt(num,2);
System.out.println("num1:"+num1);


System.out.println("Captcha:"+captcha);
if((char)num1=='.'){
System.out.println("Captcha:"+captcha);
System.exit(1);
}
else{
captcha+=(char)(num1);
}
}//if
}//while

System.out.println("num:"+num.length());


}//main
}//class
