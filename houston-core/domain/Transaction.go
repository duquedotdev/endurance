package domain

import (
	"github.com/google/uuid"
	"time"
)

type TransactionRepository interface {
	SaveTransaction(t Transaction) error
}

type Transaction struct {
	Id          string
	VendorId    string
	CustomerId  string
	MachineId   string
	Description string
	Status      string
	Amount      float64
	Installment int
	CreatedAt   time.Time
	UpdatedAt   time.Time
}

func NewTransaction() *Transaction {
	t := &Transaction{}
	t.Id = uuid.NewString()
	t.CreatedAt = time.Now().UTC()
	t.UpdatedAt = time.Now().UTC()
	return t
}

func (t *Transaction) processPayment() {
	t.Status = "Approved"
}
