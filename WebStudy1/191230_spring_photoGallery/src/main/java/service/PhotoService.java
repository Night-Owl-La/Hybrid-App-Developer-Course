package service;

import java.util.List;

import dao.PhotoDao;
import vo.PhotoVo;

public class PhotoService {
	PhotoDao photo_dao;

	public PhotoDao getPhoto_dao() {
		return photo_dao;
	}

	public void setPhoto_dao(PhotoDao photo_dao) {
		this.photo_dao = photo_dao;
	}

	public List<PhotoVo> selectList() {
		List<PhotoVo> list = null;
		list = photo_dao.selectList();

		return list;
	}

	public PhotoVo selectOne(int idx) {

		PhotoVo vo = photo_dao.selectOne(idx);
		return vo;
	}

	public int insert(PhotoVo vo) {
		int res = 0;
		res = photo_dao.insert(vo);

		return res;
	}

	public int update(PhotoVo vo) {
		int res = 0;
		res = photo_dao.update(vo);

		return res;
	}

	public int delete(int idx) {
		int res = 0;
		res = photo_dao.delete(idx);

		return res;
	}
}
