package domain

import (
	"github.com/google/uuid"
	"time"
)

type Vendor struct {
	Id        string
	Name      string
	CreatedAt time.Time
	UpdatedAt time.Time
	DeletedAt time.Time
}

func NewVendor() *Vendor {
	v := &Vendor{}
	v.Id = uuid.NewString()
	v.CreatedAt = time.Now().UTC()
	v.UpdatedAt = time.Now().UTC()
	return v
}
