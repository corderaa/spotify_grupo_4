package spotifyGrupo4.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import spotifyGrupo4.db.managers.AdminManager;
import spotifyGrupo4.db.pojo.Band;

public class AdminController {

	public void castInput(String argCreaotorName, String arg_Formation, String arg_About, String arg_members,
			String arg_image) throws SQLException, Exception {
		int nMembers = 0;
		if (arg_members.equals("") || arg_members == null)
			nMembers = 0;
		else {
			nMembers = Integer.parseInt(arg_members);

		}

		new AdminController().addNewCreator(argCreaotorName, arg_Formation, arg_About, arg_image, nMembers);

	}

	public void addNewCreator(String arg_bandName, String arg_Formation, String arg_About, String pathImage,
			int nMembers) throws SQLException, Exception {

		new AdminManager().addCreator(arg_bandName, arg_Formation, arg_About, pathImage, nMembers);

	}

	public void erase(int creatorId) throws SQLException, Exception {

		new AdminManager().delete(creatorId);

	}

	public ArrayList<Band> seeMostLiked() throws SQLException, Exception {

		return new AdminManager().getFavourites();
	}

	public ArrayList<Band> seeMostViewed() throws SQLException, Exception {

		return new AdminManager().getMostViewed();
	}

	public ArrayList<Band> seeAllCreator() throws SQLException, Exception {

		return new AdminManager().getAllCreators();
	}
}
