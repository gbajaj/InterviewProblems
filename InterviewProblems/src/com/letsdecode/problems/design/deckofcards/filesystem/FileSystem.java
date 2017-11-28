package com.letsdecode.problems.design.deckofcards.filesystem;

import java.awt.Window;

public class FileSystem {
	static FileSystem fileSystem = new FileSystem();
	static ViewerControllerFactory viewControllerFactory = new DefaultViewFactory();

	public static void main(String args[]) {
		FileSystermRegistory fileSystemRegistory = new FileSystermRegistory();
		fileSystemRegistory.init();
	}

	public void laucnViewer(String path, int viewerType) {
		
		ViewerControllerFactory viewControllerFactory = getViewerFactory(viewerType);
		FileSystemViewController fileSystemViewController
		= viewControllerFactory.createFileViewController("SimpleViewController");
		View view = fileSystemViewController.initilize("c:\\");
		
//		Window w = new Window();
//		w.add(view);
	}

	ViewerControllerFactory getViewerFactory(int type) {
		ViewerControllerFactory ret = viewControllerFactory;
		if (type == 1) {
			//
		}
		return ret;
	}
}
