/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlc_multiproxy;


import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDP_Servidor
{
	public static void main(String[] args) throws Exception
	{		
		DatagramSocket ds = new DatagramSocket(9999);
		
		byte[] b1 = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(b1, b1.length);
		ds.receive(dp);
		String str = new String(dp.getData(),0,dp.getLength());
		int num = Integer.parseInt(str.trim());
		int result = num*num;
		//recebeu do cliente
		
		byte[] b2 = String.valueOf(result).getBytes();
		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp1 = new DatagramPacket(b2, b2.length, ia, dp.getPort());
		ds.send(dp1);
		//enviou para o ciente
	}
}
	