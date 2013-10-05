///////////////////////////////////////////////////////////
//  SnakeDisplayAdapter.h
//  Implementation of the Class SnakeDisplayAdapter
//  Created on:      05-Ê®ÔÂ-2013 11:16:09
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_0D6B821A_4D2B_4142_9B09_7BC5EF5D1FDF__INCLUDED_)
#define EA_0D6B821A_4D2B_4142_9B09_7BC5EF5D1FDF__INCLUDED_

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
#endif // !defined(EA_0D6B821A_4D2B_4142_9B09_7BC5EF5D1FDF__INCLUDED_)
