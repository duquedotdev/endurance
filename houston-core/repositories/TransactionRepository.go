package repositories

import (
	"database/sql"
	"gihub.com/duquedotdev/duquebank/domain"
)

type TransactionRepository struct {
	db *sql.DB
}

func NewTransactionRepository(db *sql.DB) *TransactionRepository {
	return &TransactionRepository{db: db}
}

func (transactionRepository *TransactionRepository) SaveTransaction(transaction domain.Transaction) error {

	query := `start transaction;
    		  insert into transactions(	 id,
										 vendor_id,
										 customer_id, 
										 machine_id,  
										 description, 
										 status, 
										 amount, 
										 installment, 
										 created_at, 
										 updated_at
										 ) 
						 values($1, $2, $3, $4, $5, $6, $7, $8, $9, $10);
			  commit transaction;`

	stmt, err := transactionRepository.db.Prepare(query)

	if err != nil {
		return err
	}

	_, err = stmt.Exec(
		transaction.Id,
		transaction.VendorId,
		transaction.CustomerId,
		transaction.MachineId,
		transaction.Description,
		transaction.Status,
		transaction.Amount,
		transaction.Installment,
		transaction.CreatedAt,
		transaction.UpdatedAt,
	)

	err = stmt.Close()

	if err != nil {
		return err
	}

	return nil
}
