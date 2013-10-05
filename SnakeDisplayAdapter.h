///////////////////////////////////////////////////////////
//  SnakeDisplayAdapter.h
//  Implementation of the Class SnakeDisplayAdapter
//  Created on:      05-Ê®ÔÂ-2013 18:14:18
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_4F66675F_78B6_486a_B3CF_931526681DAA__INCLUDED_)
#define EA_4F66675F_78B6_486a_B3CF_931526681DAA__INCLUDED_

#include "DisplayInterface.h"

/**
 * Fill the display buffer
 */
class SnakeDisplayAdapter
{

public:
	SnakeDisplayAdapter();
	virtual ~SnakeDisplayAdapter();
	DisplayInterface *m_DisplayInterface;

	void FillDispBuffer();

private:
	/**
	 * a reference of DisplayInterface
	 */
	DisplayInterface& m_dispIf;
	/**
	 * Display Buffer
	 */
	char* m_dispBuf;

};
#endif // !defined(EA_4F66675F_78B6_486a_B3CF_931526681DAA__INCLUDED_)
