package idv.matt.dao;

import idv.matt.entity.ExpenseRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpenseRecordMapper {
    int deleteByPrimaryKey(@Param("idexpenseId") Integer idexpenseId, @Param("memberMemberId") Long memberMemberId);

    int insert(ExpenseRecord record);

    ExpenseRecord selectByPrimaryKey(@Param("idexpenseId") Integer idexpenseId, @Param("memberMemberId") Long memberMemberId);

    List<ExpenseRecord> selectAll();

    int updateByPrimaryKey(ExpenseRecord record);
}