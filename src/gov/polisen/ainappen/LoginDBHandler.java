package gov.polisen.ainappen;

import android.content.Context;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;

public class LoginDBHandler {

	LoginDatabaseHelper ldbh;
	Context cont;

	public LoginDBHandler(Context context){
		ldbh = LoginDatabaseHelper.getHelper(context);
		cont = context;
	}

	public void release(){
		ldbh.close();
		ldbh = null;
	}

	public boolean loginAuthenticity(LoginData loginData){
		RuntimeExceptionDao<LoginData, String> loginDataDao = ldbh.getLoginDataRuntimeExceptionDao();
		String queryId = loginData.getUserName();
		LoginData storedData = loginDataDao.queryForId(queryId);

		boolean isCorrect = false;
		isCorrect = loginData.equals(storedData);
		loginDataDao = null;
		return isCorrect;
	}

	public void makeTempLogin(LoginData loginData){
		RuntimeExceptionDao<LoginData, String> loginDataDao = ldbh.getLoginDataRuntimeExceptionDao();
		loginDataDao.createIfNotExists(loginData);
		loginDataDao = null;
		return;
	}
}
