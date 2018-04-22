package pl.coderslab.app.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom{

	@Override
	public void doStuff(int i) {
		// TODO Auto-generated method stub
		System.out.println("elo elo elo");
	}

}
