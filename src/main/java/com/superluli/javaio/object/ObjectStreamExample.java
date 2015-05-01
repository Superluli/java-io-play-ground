package com.superluli.javaio.object;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamExample {

	public static void main(String[] args) throws Exception {

		MyObject myObject = new MyObject();
		myObject.name = "lu";
		myObject.value = "xxx";
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bout);
		out.writeObject(myObject);
		System.out.println(myObject);
		byte[] arr = bout.toByteArray();
		out.close();
		bout.close();
		ByteArrayInputStream bin = new ByteArrayInputStream(arr);
		ObjectInputStream in = new ObjectInputStream(bin);
		myObject = (MyObject) in.readObject();
		System.out.println(myObject);
		in.close();
		bin.close();
	}

	static class MyObject implements Serializable {
		
		@Override
		public String toString() {
			return "MyObject [name=" + name + ", value=" + value + "]";
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		String name;
		transient String value;
	}
}
