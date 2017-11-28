package com.letsdecode.problems.design.deckofcards.filesystem;
import java.io.File;
import java.util.Date;


public class FileModel {
	File f;
	boolean selected;
	public int getFileDescriptor() {
		return fileDescriptor;
	}
	public void setFileDescriptor(int fileDescriptor) {
		this.fileDescriptor = fileDescriptor;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getCurrentState() {
		return currentState;
	}
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	public boolean isDirectory() {
		return isDirectory;
	}
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	int fileDescriptor;
	String fileName;
	String absolutePath;
	Date createdDate;
	Date lastModifiedTime;
	int permission;
	int currentState;
	boolean isDirectory;
	String extention;
}
