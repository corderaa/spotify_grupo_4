package spotifyGrupo4.controllers;

import java.util.List;

import spotifyGrupo4.db.pojo.Content;

public class AdvertController implements ControllerInterface<Content> {

	@Override
	public List<Content> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Content t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Content t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Content t) {
		// TODO Auto-generated method stub

	}

	public Content chooseRandomAdvert(List<Content> contents) {

		return contents.get((int) Math.random() * contents.size());
	}
}
