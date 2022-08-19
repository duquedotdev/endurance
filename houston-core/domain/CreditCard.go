package domain

import (
	"github.com/google/uuid"
	"time"
)

type CreditCard struct {
	id                 string
	CardNumber         float64
	CardName           string
	CardValidity       float32
	CardSecurityNumber float32
	CreatedAt          time.Time
	UpdatedAt          time.Time
	DeletedAt          time.Time
}

func NewCreditCard() *CreditCard {
	cc := &CreditCard{}
	cc.id = uuid.NewString()
	cc.CreatedAt = time.Now().UTC()
	cc.UpdatedAt = time.Now().UTC()
	return cc
}
