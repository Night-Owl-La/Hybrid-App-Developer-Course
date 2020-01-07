package service.product_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.product_dao.ProductDao;
import vo.product_vo.ProductVo;

public class ProductService_Impl implements ProductService {

	ProductDao product_In_Dao;
	ProductDao product_Out_Dao;
	ProductDao product_Remain_Dao;

	public void setProduct_In_Dao(ProductDao product_In_Dao) {
		this.product_In_Dao = product_In_Dao;
	}

	public void setProduct_Out_Dao(ProductDao product_Out_Dao) {
		this.product_Out_Dao = product_Out_Dao;
	}

	public void setProduct_Remain_Dao(ProductDao product_Remain_Dao) {
		this.product_Remain_Dao = product_Remain_Dao;
	}

	@Override
	public Map selectList() {
		List in_list = product_In_Dao.list();
		List out_list = product_Out_Dao.list();
		List remain_list = product_Remain_Dao.list();

		Map map = new HashMap();
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);

		return map;
	}

	@Override
	public int insert_in(ProductVo vo) {

		// 입곧으록
		int res = product_In_Dao.insert(vo);

		// 입고 상품이 이미 재고목록에 있는지?
		ProductVo remainVo = product_Remain_Dao.selectOne(vo.getName());
		if (remainVo == null) {
			// 재고목록에 없으면 새로 등록.
			res = product_Remain_Dao.insert(vo);
		} else {
			// 있으면 수정.
			remainVo.setCnt(remainVo.getCnt() + vo.getCnt());
			res = product_Remain_Dao.update(remainVo);
		}
		return res;
	}

	@Override
	public int insert_out(ProductVo vo) throws Exception {
		int res = product_Out_Dao.insert(vo);

		ProductVo remainVo = product_Remain_Dao.selectOne(vo.getName());

		// 출고할 상품이 없는 경우.
		if (remainVo == null) {
			throw new Exception("remain_not");
		}

		// 출고 수량 > 재고수량.
		if (vo.getCnt() > remainVo.getCnt()) {
			throw new Exception("remain_lack");
		}

		// 정상 처리.
		remainVo.setCnt(remainVo.getCnt() - vo.getCnt());
		res = product_Remain_Dao.update(remainVo);

		return res;
	}

	@Override
	public int delete_in(int idx) throws Exception {
		int res = 0;

		ProductVo inVo = product_In_Dao.selectOne(idx);
		ProductVo remainVo = product_Remain_Dao.selectOne(inVo.getName());

		// 입고상품이 재고목록에 등록이 안되있는 경우.
		if (remainVo == null) {
			throw new Exception("remain_noinput_item");
		}

		// 입고 취소 수량보다 재고 수량이 적은 경우.
		else if (inVo.getCnt() > remainVo.getCnt()) {
			throw new Exception("remain_diffcnt");
		}

		// 입고 수량보다 재고 수량이 많은 경우.
		else if (inVo.getCnt() < remainVo.getCnt()) {
			remainVo.setCnt(remainVo.getCnt() - inVo.getCnt());
			res = product_Remain_Dao.update(remainVo);
			res = product_In_Dao.delete(idx);
		}
		// 입고 수량과 재고 수량이 동일한 경우.
		else if (inVo.getCnt() == remainVo.getCnt()) {

			res = product_Remain_Dao.delete(inVo.getName());
			res = product_In_Dao.delete(idx);
		}

		return res;
	}

	@Override
	public int delete_out(int idx) throws Exception {
		int res = 0;

		ProductVo outVo = product_Out_Dao.selectOne(idx);
		ProductVo remainVo = product_Remain_Dao.selectOne(outVo.getName());

		// 출고상품이 재고목록에 등록이 안되있는 경우.
		if (remainVo == null) {
			throw new Exception("remain_nooutput_item");
		}

		// 정상처리.
		else {
			remainVo.setCnt(remainVo.getCnt() + outVo.getCnt());
			res = product_Remain_Dao.update(remainVo);
			res = product_Out_Dao.delete(idx);
		}

		return res;
	}

}
